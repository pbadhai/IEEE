package org.ieeecs.portal.authorization.authentication.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ldap.LDAPUser;
import com.liferay.portal.security.ldap.PortalLDAPExporter;
import com.liferay.portal.security.ldap.PortalLDAPUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.lowagie.text.Anchor;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * @author Pradeep Badhai - IEEE Computer Society
 *
 */

@Controller
@RequestMapping("VIEW")
public class TestController {
	private static final String FILENAME = "IEEE";
	
	@RequestMapping
	public String showForm(RenderRequest request, RenderResponse response) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
		//System.out.println("Theme Display------->:" + themeDisplay.getUser());
		
		String userEmail = UserLocalServiceUtil.getUser(PortalUtil.getUserId(request)).getEmailAddress();
		Group theGroup = UserLocalServiceUtil.getUser(PortalUtil.getUserId(request)).getGroup();
		String organizationId = UserLocalServiceUtil.getUser(PortalUtil.getUserId(request)).getOrganizationIds().toString();
		System.out.println("User email ID is---->:" + userEmail);
		System.out.println("GROUP---->:" + theGroup);
		System.out.println("Organization ID---->:" + organizationId);
		
		/*LDAPUser ldapUser = (LDAPUser)Class.forName(PropsValues.LDAP_USER_IMPL).newInstance();
		System.out.println("LDAP ldapInfo---->:" + ldapUser);
		*/
		
		/*UserLocalServiceUtil.addUser(0L,companyId, false, password, password, false, "uniquescreenname", "emailAddress", 0L, "",PortalUtil.getLocale(actionRequest), firstname, "", lastname, 0, 0, true, Calendar.JANUARY, 1, 1970, "", null, null, null, null, true, ServiceContextFactory.getInstance(
		User.class.getName(), actionRequest))*/
		
		//PortalLDAPExporter
		/*User ldapInfo = UserLocalServiceUtil.getUserByUuid(PortalLDAPExporter.class.getName());
		System.out.println("LDAP ldapInfo---->:" + ldapInfo);*/
		
		/*
		String arg1 = null;
		long id = 0;
		String arg2 = null;
		String arg3 = null;
		User ldapInfo = (User) PortalLDAPUtil.getContext(id, arg1, arg2, arg3);
		System.out.println("LDAP ldapInfo UUID---->:" + ldapInfo.getUuid());
		System.out.println("LDAP ldapInfo USER GROUP---->:" + ldapInfo.getUserGroups());
		System.out.println("LDAP ldapInfoUSER UUID---->:" + ldapInfo.getUserUuid());
		System.out.println("LDAP ldapInfo USER GROUP ID---->:" + ldapInfo.getUserGroupIds());
		*/
		
		request.setAttribute("userEmail", userEmail);
		
		String str = null;	
			try{
		        
		    	} catch (Exception e) {
		    		System.out.println("Error in " + getClass().getName() + "\n" + e);
		    	}			
			str = "view";		
			//System.out.println("This confirms that PDF Download portlet is working fine >>>>> = "+ str +"\n");		
		return str;
	}
	/*
	@ActionMapping(params = "action=actionOne") 
	 public void actionOneMethod(ActionRequest request, ActionResponse response) {
	  String userName=ParamUtil.get(request, "userName", "");
	  System.out.println("userName is >>>>> = "+userName);
	  request.setAttribute("viewResult", "viewResult");
	 }*/
	
		
	@ResourceMapping("serveInline")
    public void serveResourceInline(ResourceRequest resourceRequest, PortletRequest portletRequest, ResourceResponse res) 
    		throws PortletException, IOException {
                
        try{     	
        	resourceRequest.setCharacterEncoding(StringPool.UTF8);            
            
        	Document document = new Document();
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	PdfWriter.getInstance(document, baos);
        	document.open();
        	Anchor anchorTarget = new Anchor("Welcome to IEEE Document Download Center.");
            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();

            paragraph1.setSpacingBefore(50);

            paragraph1.add(anchorTarget);
            document.add(paragraph1);

            document.add(new Paragraph("Some more text on the \fFirst page with different color and font type. Enjoy your Day",            		

            FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
        	
            //document.open();
            document.close();
            
            res.setContentType("application/pdf");
            res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=IEEE.pdf");
            
            OutputStream out = res.getPortletOutputStream();
            
            byte[] downloadBytes = Base64.decode((String)resourceRequest.getAttribute("fileToDownloadBase64"));
        	
        	//wb.write(os);
            out.write(downloadBytes);
            baos.writeTo(out);
            out.flush();
            out.close();
    	} catch (Exception e) {
    		System.out.println("Error in " + getClass().getName() + "\n" + e);
    	}
    }
	
	@ResourceMapping("serveAttachment")
    public void serveResourceDownload(ResourceRequest resourceRequest, PortletRequest portletRequest, ResourceResponse res) 
    		throws PortletException, IOException {
                
        try{
        	resourceRequest.setCharacterEncoding(StringPool.UTF8);
        	Document document = new Document();
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	PdfWriter.getInstance(document, baos);
        	document.open();
        	Anchor anchorTarget = new Anchor("Welcome to IEEE Document Download Center.");
            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();

            paragraph1.setSpacingBefore(50);

            paragraph1.add(anchorTarget);
            document.add(paragraph1);

            document.add(new Paragraph("Some more text on the \fFirst page with different color and font type. Enjoy your Day",            		

            FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
        	
            //document.open();
            document.close();
            
            res.setContentType("application/pdf");
            res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=IEEE.pdf");
            
            OutputStream out = res.getPortletOutputStream();
            
            byte[] downloadBytes = Base64.decode((String)resourceRequest.getAttribute("fileToDownloadBase64"));
        	
            
        	//wb.write(os);
            out.write(downloadBytes);
            baos.writeTo(out);
            out.flush();
            out.close();
    	} catch (Exception e) {
    		System.out.println("Error in " + getClass().getName() + "\n" + e);
    	}
    }
}
