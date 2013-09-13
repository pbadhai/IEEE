<%@ include file="init.jsp"%>
<%-- <%@ include file="cdcInit.jsp"%> --%>

<%@ page import="java.net.*"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.io.File"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.io.File,java.io.FilenameFilter,java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="init.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> --%>

<!-- <portlet:defineObjects/> -->

<!-- Developer: Pradeep Badhai - IEEE  Computer Society-->

<%-- <portlet:resourceURL var="JSPResourceURL">
</portlet:resourceURL> --%>

<portlet:resourceURL id="serveInline" var="serveInlineURL"> 
</portlet:resourceURL>
<%-- <portlet:renderURL value = "renderURL1">
</portlet:renderURL>  --%>

<%-- <portlet:resourceURL id="serveAttachment" var="serveAttachmentURL"> 
</portlet:resourceURL> --%>

This is User Info Email Detail:
<p>
<c:out value="${userEmail}" />
<p>
<c:out value="${userEmail}" />
</p>

<p>This is a SpringMVC ResourceMapping example for PDF Render and Download Example </p>

<input type="button" name="viewPDFButton" value="Run Report" onClick="self.location = '${serveInlineURL}';" />
&nbsp;&nbsp;&nbsp;&nbsp;

<input type="button" name="viewPDFButton1" value="Download Report" onClick="self.location = '${serveAttachmentURL}';" />