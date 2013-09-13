<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
 <!-- Developer: Pradeep Badhai pbadhai@bostonfinancial.com  -->
<META HTTP-EQUIV="Content-Type" CONTENT="text/plain; charset=utf-8" >
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib  prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page isELIgnored="false" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page session="true" contentType="text/html" pageEncoding="UTF-8" import="java.util.*,javax.portlet.*" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page language="java" import="java.net.*" import="java.io.*"
        import="com.liferay.portal.util.PortalUtil"%>

<portlet:defineObjects />
