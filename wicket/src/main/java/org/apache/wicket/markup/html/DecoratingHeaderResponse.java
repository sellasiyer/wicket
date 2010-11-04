/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.markup.html;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.Response;

/**
 * This is simply a helper implementation of IHeaderResponse that really delegates all of its method
 * calls to the IHeaderResponse that is passed into the constructor. It is defined as abstract
 * because it's only meant to be extended and not used a la carte. You can extend it and override
 * only the methods that you want to change the functionality of.
 * 
 * @see IHeaderResponseDecorator
 * @see IHeaderResponse
 * @author Jeremy Thomerson
 */
public abstract class DecoratingHeaderResponse implements IHeaderResponse
{

	private final IHeaderResponse realResponse;

	/**
	 * Create a header response that simply delegates all methods to the one that is passed in here.
	 * 
	 * @param real
	 *            the actual response that this class delegates to by default
	 */
	public DecoratingHeaderResponse(IHeaderResponse real)
	{
		realResponse = real;
	}

	/**
	 * Returns the actual response being decorated for subclasses to be able to pass it off to other
	 * objects if they need to do so.
	 * 
	 * @return the actual wrapped IHeaderResponse
	 */
	protected final IHeaderResponse getRealResponse()
	{
		return realResponse;
	}

	public void renderJavascriptReference(ResourceReference reference)
	{
		realResponse.renderJavascriptReference(reference);
	}

	public void renderJavascriptReference(ResourceReference reference, String id)
	{
		realResponse.renderJavascriptReference(reference, id);
	}

	public void renderJavascriptReference(String url)
	{
		realResponse.renderJavascriptReference(url);
	}

	public void renderJavascriptReference(String url, String id)
	{
		realResponse.renderJavascriptReference(url, id);
	}

	public void renderJavascript(CharSequence javascript, String id)
	{
		realResponse.renderJavascript(javascript, id);
	}

	public void renderCSSReference(ResourceReference reference)
	{
		realResponse.renderCSSReference(reference);
	}

	public void renderCSSReference(String url)
	{
		realResponse.renderCSSReference(url);
	}

	public void renderCSSReference(ResourceReference reference, String media)
	{
		realResponse.renderCSSReference(reference, media);
	}

	public void renderCSSReference(String url, String media)
	{
		realResponse.renderCSSReference(url, media);
	}

	public void renderString(CharSequence string)
	{
		realResponse.renderString(string);
	}

	public void markRendered(Object object)
	{
		realResponse.markRendered(object);
	}

	public boolean wasRendered(Object object)
	{
		return realResponse.wasRendered(object);
	}

	public Response getResponse()
	{
		return realResponse.getResponse();
	}

	public void renderOnDomReadyJavascript(String javascript)
	{
		realResponse.renderOnDomReadyJavascript(javascript);
	}

	public void renderOnLoadJavascript(String javascript)
	{
		realResponse.renderOnLoadJavascript(javascript);
	}

	public void renderOnEventJavascript(String target, String event, String javascript)
	{
		realResponse.renderOnEventJavascript(target, event, javascript);
	}

	public void close()
	{
		realResponse.close();
	}

	public boolean isClosed()
	{
		return realResponse.isClosed();
	}

}
