/*
 * Copyright (c) 2010 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavix.util.screenscrape.annotation;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import net.sf.saxon.om.NodeInfo;

import org.xml.sax.InputSource;

import vavi.beans.BeanUtil;


/**
 * XPathParser. 
 *
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 2010/10/01 nsano initial version <br>
 */
public class SaxonXPathParser<T> implements Parser<Reader, T> {
    
    /** */
    protected XPath xPath;
    
    {
        System.setProperty(XPathFactory.DEFAULT_PROPERTY_NAME + ":" + XPathFactory.DEFAULT_OBJECT_MODEL_URI, "net.sf.saxon.xpath.XPathFactoryImpl");    
        xPath = XPathFactory.newInstance().newXPath();
//System.err.println(XPathFactory.newInstance().getClass());
    }

    /** */
    public List<T> parse(Class<T> type, InputHandler<Reader> inputHandler, String ... args) {
        try {
            String encoding = WebScraper.Util.getEncoding(type);
System.err.println("encoding: " + encoding);

            List<T> results = new ArrayList<T>();

            Set<Field> targetFields = WebScraper.Util.getTargetFields(type);
            for (Field field : targetFields) {

                InputSource in = new InputSource(inputHandler.getInput(args));
                in.setEncoding(encoding);

                String xpath = Target.Util.getValue(field);
System.err.println("xpath: " + xpath);
                if (WebScraper.Util.isCollection(type)) {
                    
                    @SuppressWarnings("unchecked")
                    List<NodeInfo> nodeList = (List<NodeInfo>) xPath.evaluate(xpath, in, XPathConstants.NODESET);
System.err.println("nodeList: " + nodeList.size());
                    for (int i = 0; i < nodeList.size(); i++) {
                        T bean = null;
                        try {
                            bean = results.get(i);
                        } catch (IndexOutOfBoundsException e) {
                            bean = type.newInstance();
                            results.add(bean);
                        }

                        String text = nodeList.get(i).getStringValue().trim();
//System.err.println(field.getName() + ": " + text);
                        BeanUtil.setFieldValue(field, bean, text);
                    }
                } else {
                    T bean = null;
                    try {
                        bean = results.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        bean = type.newInstance();
                        results.add(bean);
                    }

                    String text = ((String) xPath.evaluate(xpath, in, XPathConstants.STRING)).trim();
                    BeanUtil.setFieldValue(field, bean, text);
                }
            }
            
            return results;

        } catch (XPathExpressionException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /** TODO implement */
    public void foreach(Class<T> type, EachHandler<T> eachHandler, InputHandler<Reader> inputHandler, String ... args) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}

/* */
