<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap/3.3.6/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/my.js"></script>
<title>个人待办事项管理系统</title>
</head>
<body>
    <div class="login" style="margin-top:120px;">
    
        <div class="header">
            <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
                <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
            </div>
        </div>    
      
        
        <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    
				<label id="userlg"></label>
                <!--登录-->
                <div class="web_login" id="web_login">

                   <div class="login-box">
                
                        <div class="login_form">
                            <form action="loginCheck" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
                                <input type="hidden" name="to" value="log"/>
                                <div class="uinArea" id="uinArea">
                                	<label class="input-tips" for="u">帐号：</label>
                                    <div class="inputOuter" id="uArea">
                                        <input type="text" id="u" name="USER_NAME" class="inputstyle"/>
                                    </div>
                                </div>
                                <div class="pwdArea" id="pwdArea">
                                	<label class="input-tips" for="p">密码：</label> 
                                    <div class="inputOuter" id="pArea">
                                        <input type="password" id="p" name="PASSWORD" class="inputstyle"/>
                                    </div>
                                </div>
                               
                                <div style="padding-left:50px;margin-top:20px;">
                                	<input type="submit" value="登 录" id="login" style="width:150px;" class="button_blue"/>
                                </div>
                          </form>
                       </div>
               
                    </div>
                   
                </div>
        </div>
        <!--登录end-->

        <!--注册-->
        <div class="qlogin" id="qlogin" style="display: none; ">
       
        <div class="web_login">
            <form name="form2" id="regUser" accept-charset="utf-8"  action="Register" method="post">
              <input type="hidden" name="to" value="reg"/>
              <input type="hidden" name="did" value="0"/>
              <div id="userCue" class="cue">快速注册请注意格式</div>
            	<ul class="reg_form" id="reg-ul">
                    
                    <li>
                        <label for="user"  class="input-tips2">用户名：</label>
                        <div class="inputOuter2">
                            <input type="text" id="user" name="USER_NAME" maxlength="16" class="inputstyle2"/>
                        </div>
                    </li>
                    
                    <li>
                        <label for="passwd" class="input-tips2">密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="passwd"  name="PASSWORD" maxlength="16" class="inputstyle2"/>
                        </div>
                        
                    </li>

                    <li>
                        <label for="passwd2" class="input-tips2" id="confirmlabel">确认密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="passwd2" name="sencond_password" maxlength="16" class="inputstyle2" />
                        </div>
                        
                    </li>
                    
                    
                    <li>
                    	<label for="passwd2" class="input-tips2">性别：</label>
                   		 <div  class="inputOuter2">
						      <select name="SEX"  id="inputState" class="form-control">
						        <option value="F"selected>男</option>
						        <option value="M">女</option>
						      </select>
						</div>
					</li>
					<li>
                        <label for="age" class="input-tips2">年龄：</label>
                        <div class="inputOuter2">
                            <input type="text" id="userage" name="AGE" maxlength="3" class="inputstyle2"/>
                        </div>
                       
                    </li>
					<li>
                        <label for="qq" class="input-tips2">电话号码：</label>
                        <div class="inputOuter2">
                            <input type="text" id="phonenumber" name="PHONE_NUMBER" maxlength="11" class="inputstyle2"/>
                        </div>
                       
                    </li>
                    <li>
                        <label for="qq" class="input-tips2">备注：</label>
                        <div class="inputOuter2">
                            <input type="text" id="comments" name="COMMENTS" maxlength="50" class="inputstyle2"/>
                        </div>
                       
                    </li>
                    
                    <li>
                        <div class="inputArea">
                            <input type="submit" id="reg"  style="margin-top:10px;margin-left:125px;" class="button_blue" value="注        册"/> 
                        </div> 
                    </li>
                    
                   
                </ul>
            </form>
               
        </div>
        </div>
    <!--注册end-->
    </div>
</body>