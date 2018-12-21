package com.trustaml.dataservice.common.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trustaml.dataservice.common.dao.EnumDAO;

@RestController
public class CommonController {

	@Autowired
	EnumDAO enumDAO;

	/**
	 * Request mapping for '/getCategories'. Uses
	 * EnumDAO.getScreeningRequestEnumJson
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @see EnumDAO
	 */
	@CrossOrigin
	@RequestMapping(value = "/getCategories", method = RequestMethod.POST)
	public @ResponseBody void getCategories(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(this.getClass().getSimpleName() + ":" + methodName + " method invoked.");
		String categoryKeys = request.getParameter("data");
		System.out.println("Category keys received: " + categoryKeys);
		String categoryValues = "";
		enumDAO.getCategoriesJson("{\"data\": " + categoryKeys + "}");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().println(categoryValues);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/lists/master/searchForm", method = RequestMethod.GET)
	public ModelAndView masterSearchForm(ModelAndView model,
			@RequestParam(required = false, value = "search") String search) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(this.getClass().getSimpleName() + ":" + methodName + " method invoked.");
		model.addObject("search", search);
		model.setViewName("master/master-search");
		return model;
	} // end of

	/**
	 * 
	 * @param search
	 * @description return match details for search query
	 * @see masterDAO
	 * @return
	 */
	/*
	 * @RequestMapping(value="/lists/master/findMatch",
	 * method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	 * 
	 * @ResponseBody public String masterSearchDetail(@RequestParam("search")
	 * String search){
	 * 
	 * String response = "";
	 * 
	 * try{ response = masterDAO.findMatchDetail(search); }catch(Exception e){
	 * e.printStackTrace(); }
	 * 
	 * return response;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/lists/master/getMatchDetails", method =
	 * RequestMethod.GET) public ModelAndView getMatchDetails(ModelAndView
	 * model, @RequestParam("id") long id, @RequestParam("name") String
	 * name, @RequestParam(value="activate", required=false, defaultValue="")
	 * String activate ) { String methodName = new Object() {
	 * }.getClass().getEnclosingMethod().getName();
	 * System.out.println(this.getClass().getSimpleName() + ":" + methodName +
	 * " method invoked."); System.out.println("Id: " + id);
	 * System.out.println("NAME: " + name); model.addObject("id", id);
	 * model.addObject("name",name); model.addObject("activate",activate);
	 * model.setViewName("master/common-match-detail"); return model; }
	 * 
	 *//**
		 * 
		 * @param id
		 * @param name
		 * @param response
		 * @description provide details match information from id and name
		 *              parameter
		 * @see masterDAO
		 *//*
		 * @RequestMapping(value = "/lists/master/getMatchDetailsJsonString",
		 * method = RequestMethod.POST) public void
		 * getMatchDetailsJsonString(@RequestParam("id") long
		 * id,@RequestParam("name")String name, HttpServletResponse response) {
		 * String methodName = new Object() {
		 * }.getClass().getEnclosingMethod().getName();
		 * System.out.println(this.getClass().getSimpleName() + ":" + methodName
		 * + " method invoked."); String matchDetailJsonString =
		 * masterDAO.getMatchDetails(id,name);
		 * System.out.println("Match details :" + matchDetailJsonString);
		 * response.setCharacterEncoding("UTF-8"); try {
		 * response.getWriter().println(matchDetailJsonString); } catch
		 * (IOException e) { e.printStackTrace(); } }
		 * 
		 * @RequestMapping(value = "/lists/master/getPepDetails", method =
		 * RequestMethod.GET) public ModelAndView getPepDetails(ModelAndView
		 * model, @RequestParam("id") long pepId, @RequestParam(required=false,
		 * value="search") String search) { String methodName = new Object() {
		 * }.getClass().getEnclosingMethod().getName();
		 * System.out.println(this.getClass().getSimpleName() + ":" + methodName
		 * + " method invoked."); System.out.println("Pep Id: " + pepId);
		 * model.addObject("pepId", pepId); model.addObject("search", search);
		 * model.setViewName("master/hrp-details"); return model; }
		 * 
		 * @CrossOrigin
		 * 
		 * @RequestMapping(value = "/getCategoriesByUserName", method =
		 * RequestMethod.POST) public @ResponseBody String
		 * getCategoriesByUserName(@RequestBody String jsonData) throws
		 * IOException { JSONObject json = new JSONObject(jsonData); String
		 * username = userDAO.getUsername(); String categoryKeys =
		 * json.getString("data"); String categoryValues =
		 * enumDAO.getCategoriesJsonByUserName(categoryKeys,username); return
		 * categoryValues; } // end of
		 * 
		 * @CrossOrigin
		 * 
		 * @RequestMapping(value = "/getCategoriesByUserScope", method =
		 * RequestMethod.POST) public @ResponseBody String
		 * getCategoriesByScope() throws IOException { User user =
		 * userDAO.getUserDetails(userDAO.getUsername()); return
		 * enumDAO.getUserScopeJson(user.getUserscope()); } // end of
		 * 
		 * @CrossOrigin
		 * 
		 * @RequestMapping(value = "/getCategoriesAsKeyValue", method =
		 * RequestMethod.POST) public @ResponseBody void
		 * getCategoriesAsKeyValue(HttpServletRequest request,
		 * HttpServletResponse response) throws IOException { String methodName
		 * = new Object() { }.getClass().getEnclosingMethod().getName();
		 * System.out.println(this.getClass().getSimpleName() + ":" + methodName
		 * + " method invoked."); String categoryKeys =
		 * request.getParameter("data");
		 * System.out.println("Category keys received: " + categoryKeys); String
		 * categoryValues = enumDAO.getCategoriesJsonAsKeyValue("{\"data\": " +
		 * categoryKeys + "}"); response.setCharacterEncoding("UTF-8"); try {
		 * response.getWriter().println(categoryValues); } catch (IOException e)
		 * { e.printStackTrace(); } }
		 */

}
