<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${admin.admName }</title>
<jsp:include page="/WEB-INF/include/meta.jsp"></jsp:include>
<jsp:include page="/WEB-INF/include/css-jquery.jsp"></jsp:include>
<jsp:include page="/WEB-INF/include/adaptor.jsp"></jsp:include>
<jsp:include page="/WEB-INF/include/redirectPage.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<!-- 主页链接  -->
			<a href="admin!index.action" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">★</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg">${prop.systemName }</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<!-- FUNCTION 左上角缩小 -->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>	

				<!-- FUNCTION	自定义用户菜单  -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->

						<!-- User Account: style can be found in dropdown.less -->
						
							
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">${admin.admName }</span></a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">
									<p>
										${admin.admName }
									</p></li>

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a onclick="updatePassword();" class="btn btn-default btn-flat">修改密码</a>
									</div>
									<div class="pull-right">
										<a onclick="exit();" class="btn btn-default btn-flat">登出</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="../dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>管理员</p>
					</div>
				</div>
				<!-- search form -->
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="nav sidebar-menu">
					<li class="header">主导航</li>
					<!-- <li><a href="#" onclick="redirectPage('index')" class='active'> <i
							class="fa fa-navicon"></i> <span>系统信息查看</span>
					</a></li> -->
					<li><a href="#" onclick="redirectPage('systemConfig')"> <i
							class="fa fa-wrench"></i> <span>班级配置</span>
					</a></li>
					<li><a href="#" onclick="redirectPage('teacherManager')">
							<i class="fa fa-users"></i> <span>教师管理</span>
					</a></li>
					<li><a href="#" onclick="redirectPage('studentManager')">
							<i class="fa fa-users"></i> <span>学生管理</span>
					</a></li>
					<li><a href="#" onclick="redirectPage('resourceManager')">
							<i class="fa fa-navicon"></i> <span>资源审核</span>
					</a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Main content -->
			<section>
				<div id="main"></div>
				<!-- /.error-page -->
			</section>
			<!-- /.content -->
		</div>
		
		<!-- /.content-wrapper -->
		<jsp:include page="/WEB-INF/include/footer.jsp"></jsp:include>
		
		<div class="modal" id="updatePasswordModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="updatePasswordTitle">修改密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updatePasswordForm"
						action="school!updatePassword.action">
						<div class="box-body">
							<div class="form-group">
								<label class="col-sm-2">密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"	name="oldPassword" placeholder="密码">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2">新密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"	name="newPassword" placeholder="新密码">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2">确认密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"	name="confirmPassword" placeholder="确认密码">
								</div>
							</div>
							<!-- /.box-body -->
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="updatePasswordSave" class="btn btn-primary">保存</button>
					<button type="button" id="updatePasswordCancel" class="btn btn-default"
						data-dismiss="modal">取消</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	</div>
	<!-- ./wrapper -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('ul.nav > li').click(function(e) {
			e.preventDefault();
			$('ul.nav > li').removeClass('active');
			$(this).addClass('active');
		});
		redirectPage("systemConfig");
	});

	function redirectPage(flag) {
		var url = "${sessionScope.userType }!redirectPage.action?flag="+flag;
		$("#main").load(url);
	}
	function exit(){
		location.href="../login!exit.action";
	}
	$('.dropdown').click(function(){
		$(this).addClass('open');
	})
	function updatePassword(){
		$('#updatePasswordModal').modal('show');
	}

	$("#updatePasswordSave").click(function() {
		$("#updatePasswordForm").ajaxSubmit(function(data) {
			if(data.result=="success"){
				bootbox.alert("操作成功");
				($("#updatePasswordForm"))[0].reset();
				$('#updatePasswordModal').modal('hide');
			}
			else{
				bootbox.alert(data.reason);
			}
		})
		$('#branchModal').modal('hide');
	});
</script>
</html>
