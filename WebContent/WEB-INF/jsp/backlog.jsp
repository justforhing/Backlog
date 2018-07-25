<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/backlog.css" rel="stylesheet" type="text/css" />
<script src="js/backlog.js"></script>

<title>个人主页</title>
</head>
<body>
    <div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-12 is ">
            <div id="title">
                <h1 class="text-center">
                   	 个人待办事项管理系统
                </h1>
            </div>
             <div id="thehead" class="dropdown">
                  <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                       	 个人中心
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#" id="information">个人信息维护</a></li>
                    <li><a href="#" id="pwd">修改密码</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="logOut">退出登录</a></li>
                  </ul>
                                
               </div>
      
                    
            </div><!-- dropdown-menu -->
            <div id="welcome"><h4>欢迎您！${ sessionScope.currentUser.USER_NAME}</h4></div>
            
            <div class="row-fluid">
            	
            	<h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总共：${total}</h5>
            		
                <div class="col-md-7 is ">
                    <form class="form-search" action="findAboutItem" method="post">
                            <input class="input-medium search-query" type="text" name="key" placeholder="输入关键词查找" /> 
                            <button type="submit" class="btn btn-info">查找</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button"  id="goToAdd" class="btn btn-success">+新</button>
            	
                    </form>
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="getLeastItems">最新</a>
                        </li>
                        <li >
                            <a href="getLastUpdateItems">修改日期</a>
                        </li>
                        <li>
                            <a href="getAllItems">全部</a>
                        </li>
                        
                        <li class="dropdown pull-left">
                             <a href="#" data-toggle="dropdown" class="dropdown-toggle">优先级<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="getHighItems">高级</a>
                                </li>
                                <li>
                                    <a href="getMediumItems">中级</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="getLowItems">低级</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                     	标题
                                </th>
                                <th>
                                      	优先级
                                </th>
                                <th>
                                     	 创建时间
                                </th>
                                <th>
                                     	备注
                                </th>
                                <th>
                                    	 详情
                                </th>
                                <th>
                                     	删除
                                </th>
                            </tr>
                        </thead>
                        
                        
                        <tbody>
                        	<c:choose>
                        		<c:when test="${!empty is}">
                        			<c:forEach items="${is}" var="c" varStatus="st" >
		                             <c:choose>
		                                   <c:when test="${c.PRIORITY == 'HIGH'}">
		                                     <tr  class="warning">
		                                        <td id="itemid">
		                                            ${c.TODO_ITEM_TITLE}
		                                        </td>
		                                        <td>
		                                        	高级 
		                                        </td>
		                                        <td>
		                                            ${c.CREATION_DATE }
		                                        </td>
		                                        <td>
		                                            ${c.COMMENTS }
		                                        </td>
		                                        <td>
		                                            <form action="editItem" method="POST" class="detailform">
		                                                <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                <button type="submit"  class="btn btn-info">详情</button>
		                                            </form> 
		                                        </td>
		                                        <td>
		                                            <form action="deleteItem" method="POST">
		                                                <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                <button type="submit" class="btn btn-info">删除</button>
		                                            </form>
		                                        </td>
		                                    </tr>
		                                   </c:when>
		                                   <c:when test="${c.PRIORITY == 'MEDIUM'}">
		                                     <tr  class="info">
		                                         <td id="itemid">
		                                             ${c.TODO_ITEM_TITLE}
		                                         </td>
		                                         <td>
		                                             	中级
		                                         </td>
		                                         <td>
		                                             ${c.CREATION_DATE }
		                                         </td>
		                                         <td>
		                                             ${c.COMMENTS }
		                                         </td>
		                                         <td>
		                                             <form action="editItem" method="POST" class="detailform">
		                                                 <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                 <button type="submit"  class="btn btn-info">详情</button>
		                                             </form> 
		                                         </td>
		                                         <td>
		                                             <form action="deleteItem" method="POST">
		                                                 <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                 <button type="submit" class="btn btn-info">删除</button>
		                                             </form>
		                                         </td>
		                                     </tr>
		                                   </c:when>
		                                   <c:otherwise>
		                                    <tr  class="success">
		                                         <td id="itemid">
		                                             ${c.TODO_ITEM_TITLE}
		                                         </td>
		                                         <td>
		                                            	 低级
		                                         </td>
		                                         <td>
		                                             ${c.CREATION_DATE }
		                                         </td>	  
		                                         <td>
		                                             ${c.COMMENTS }
		                                         </td>
		                                         <td>
		                                             <form action="editItem" method="POST" class="detailform">
		                                                 <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                 <button type="submit"  class="btn btn-info">详情</button>
		                                             </form> 
		                                         </td>
		                                         <td>
		                                             <form action="deleteItem" method="POST">
		                                                 <input type="hidden" name="TODO_ITEM_ID" value="${c.TODO_ITEM_ID}" />
		                                                 <button type="submit" class="btn btn-info">删除</button>
		                                             </form>
		                                         </td>
		                                     </tr>
		                                   </c:otherwise>
		                                </c:choose>
		                       		 </c:forEach>
                        		</c:when>
                        		<c:otherwise>
                        			<tr>
	                        		
			                               <td colspan="6">	 对不起，你还有添加待办事项！</td>
			                           
		                            </tr>
                        		</c:otherwise>
                        		
                        	</c:choose>
                            
                        </tbody>
                    </table>
                     <div class="pagination ">
                       <nav aria-label="Page navigation">
                         <ul class="pagination pagination-lg ">
                           <div style="text-align:center">
                           		<c:choose>
                           			<c:when test="${page.start-page.count >= 0}">
                           				<a href="showMyItems?start=0">首  页</a>
		                                <a href="showMyItems?start=${page.start-page.count}">上一页</a>
		                                <a href="showMyItems?start=${page.start+page.count}">下一页</a>
		                                <a href="showMyItems?start=${page.last}">末  页</a>
                           			</c:when>
                           			<c:otherwise>
                           				<a href="showMyItems?start=0">首  页</a>
		                                <a href="showMyItems?start=0">上一页</a>
		                                <a href="showMyItems?start=${page.start+page.count}">下一页</a>
		                                <a href="showMyItems?start=${page.last}">末  页</a>
                           			</c:otherwise>
                           		</c:choose>
                           </div>
                         </ul>
                       </nav>
                    </div>
                </div><!-- col-md-8 is -->
                
                <!-- 添加待办事项-->
                <div id="addItem" class="col-md-5 is ">
                    <form action="addItem" method="post">
                     <div id="userCue2" class="cue">**请注意格式**</div>
                    <div class="form-row">
                            <div class="form-group col-md-8">
                              <label for="inputEmail4">标题</label>
                              <input type="text" class="form-control" name="TODO_ITEM_TITLE" id="titleadd" placeholder="title">
                            </div>
                             <div class="form-group col-md-3">
                              <label for="inputState">优先级</label>
                                  <select name="PRIORITY" class="form-control">
                                    <option value="HIGH" selected>高</option>
                                    <option value="MEDIUM">中</option>
                                    <option value="LOW">低</option>
                                  </select>
                            </div>
                            <div class="form-group col-md-10">
                              <label for="inputContent">内容</label>
                              <textarea class="form-control" rows="10" cols="100" name="TODO_ITEM_CONTENT" placeholder="content"></textarea>
                            </div>
                          </div>
                        
                          <div class="form-group col-md-6">
                            <label for="inputAddress2">备注</label>
                            <input type="text" class="form-control" id="inputAddres" name="COMMENTS" placeholder="comments">
                          </div>

                          <br><br>
                          <div class="form-row col-md-10">
                            <button type="submit" id="btnAddItem" class="btn btn-primary">添加</button>
                          </div>
                    </form>
                    
                </div>
                <!-- col-md-4 is -->
                
                  <!-- 查看待办事项-->
                  <c:if test="${currentItem != null }">
                  	<div id="editItem" class="col-md-5 is ">
                    <form action="updateItem" method="post">
                    <div id="userCue3" class="cue">**请注意格式**</div>
                        <div class="form-group col-md-8">
                          <label for="inputEmail4">标题</label>
                          <input name="TODO_ITEM_TITLE" value="${currentItem.TODO_ITEM_TITLE }" type="text" class="form-control" id="itemtitle"  name="TODO_ITEM_TITLE "placeholder="title">
                        </div>
                         <div class="form-group col-md-3">
                            <label for="inputState">优先级</label>
                              <select name="PRIORITY" class="form-control">
                                 <c:choose>
								   <c:when test="${currentItem.PRIORITY == 'HIGH'}">
								   	 <option value="HIGH" selected>高</option>
                                	 <option value="MEDIUM">中</option>
                                	 <option value="LOW">低</option>
								   </c:when>
								   <c:when test="${currentItem.PRIORITY == 'MEIEUM'}">
								   	 <option value="HIGH" >高</option>
                                	 <option value="MEDIUM" selected>中</option>
                                	 <option value="LOW">低</option>
								   </c:when>
								   <c:otherwise>
								  	 <option value="HIGH" >高</option>
                                	 <option value="MEDIUM">中</option>
                                	 <option value="LOW" selected>低</option>
								   </c:otherwise>
								</c:choose>
                              </select>
                        </div>
                        <div class="form-group col-md-12">
                          <label for="inputContent">内容</label>
                          <textarea   class="form-control" name="TODO_ITEM_CONTENT" rows="8" cols="120" placeholder="content">${currentItem.TODO_ITEM_CONTENT }</textarea>
                        </div>
                    
                      <div class="form-group col-md-6">
                        <label for="inputAddress2">备注</label>
                        <input  value="${currentItem.COMMENTS }" type="text" name="COMMENTS" class="form-control" id="COMMENTS" placeholder="comments">
                      </div>
                        
                        <div class="form-group col-md-6">
                          <label for="inputCity">创建日期</label>
                          <input  value="${currentItem.CREATION_DATE }" type="text" readonly="readonly" name="CREATION_DATE" class="form-control" id="createtime1">
                        </div>
                      
                        <div class="form-group col-md-6">
                          <label for="inputCity">上次修改的日期</label>
                          <input  value="${currentItem.LAST_UPDATE_DATE }" type="text" readonly="readonly" name="LAST_UPDATE_TIME" class="form-control" id="updattime">
                        </div>

                      <div class="form-row col-md-10">
                        <input value="${currentItem.TODO_ITEM_ID}"  name="TODO_ITEM_ID" type="hidden">
                        <button id="btnItemCheck" type="submit" class="btn btn-primary">提交</button>
                      </div>
                    </form>
                </div> 
              </c:if>
                  
                
                <!-- col-md-4 is -->
                
                
                <!-- 修改密码 -->

                <div id="changPassword" class="col-md-5 is ">
                    <form action="updatePassword" method="post">
                        <div id="userCue" class="cue">**修改密码请注意格式**</div>
                        <div class="form-group col-md-8">
                          <label for="inputOldPassword">当前密码</label>
                          <input type="password" name="OLDPASSWORD" class="form-control" id="OldPassword" placeholder="Password">
                        </div>
                        <div class="form-group col-md-8">
                          <label for="inputPassword4">新密码</label>
                          <input type="password" name="PASSWORD" class="form-control" id="newPassword1" placeholder="newPassword">
                        </div>
                        <div class="form-group col-md-8">
                          <label for="inputPassword4">再输入一次</label>
                          <input type="password" name="secondPassword" class="form-control" id="newPassword2" placeholder="newPassword">
                        </div>
                        
                        <div class="form-group col-md-8">
                       
                        	<input value=" ${ sessionScope.currentUser.USER_ID}" type="hidden" name="USER_ID">
                          <button type="submit" id="btnpwd" class="btn btn-primary">修改</button>
                        </div>
                    </form>
                </div>
                <!-- col-md-4 is -->
                
                 <!-- 修改个人信息 -->
              
                 <div id="changeInformation" class="col-md-5 is ">
                    <form action="updateInformation" method="post">
                    	<div id="userCue1" class="cue">**请注意格式**</div>
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="inputEmail4">姓名</label>
                              <input type="text" value="${sessionScope.currentUser.USER_NAME}" name="USER_NAME" class="form-control" id="name" value="" placeholder="name">
                            </div>
                             <div class="form-group col-md-4">
                              <label for="inputState">性别</label>
                              <select name="SEX" class="form-control">
                              	<c:choose>
								   <c:when test="${sessionScope.currentUser.SEX == 'M'}">
								   	<option value="M" selected>男</option>
	                                <option value="F">女</option>
								   </c:when>
								   
								   <c:otherwise>
								   	<option value="M" >男</option>
	                                <option value="F" selected>女</option>
								   </c:otherwise>
								</c:choose>
                              </select>
                            </div>
                            <div class="form-group col-md-2">
                              <label for="inputPassword4">年龄</label>
                              <input type="text" name="AGE" value="${sessionScope.currentUser.AGE }" class="form-control" id="ageinput" placeholder="age">
                            </div>
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputPassword4">电话号码</label>
                            <input type="text" class="form-control" value="${sessionScope.currentUser.PHONE_NUMBER }" id="phone" name="PHONE_NUMBER" placeholder="Tel">
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputAddress2">备注</label>
                            <input type="text" class="form-control" id="commentinput" value="${sessionScope.currentUser.COMMENTS }" name="COMMENTS" placeholder="comments">
                          </div>
                          <div class="form-row">
                            <div class="form-group col-md-12">
                              <label for="inputCity">创建日期</label>
                              <input type="text" readonly="readonly" value="${sessionScope.currentUser.CREATION_DATE }" name="CREATION_DATE" class="form-control" id="createtime">
                            </div>
        
                          </div>
                          <br><br>
                          <div class="form-row col-md-10">
                            <button type="submit" id="btnUpdateInformation" class="btn btn-primary">修改</button>
                          </div>
                    </form>
                </div>
                
                <!-- col-md-4 is -->
                
            </div>
        </div>
    </div>
</div>   
    <div id="footer"><p>©CopyRight By justforhing in 2018.7</p></div>
</body>
</html>