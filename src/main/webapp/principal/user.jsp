<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>
	<!-- Pre-loader start -->
	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<!-- navbar -->
			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<nav class="pcoded-navbar">
						<div class="sidebar_toggle">
							<a href="#"><i class="icon-close icons"></i></a>
						</div>

						<jsp:include page="navbar-main-menu.jsp"></jsp:include>

					</nav>
					<div class="pcoded-content">
						<!-- Page-header start -->
						<div class="page-header">
							<div class="page-block">
								<div class="row align-items-center">
									<div class="col-md-8">
										<div class="page-header-title">
											<h5 class="m-b-10">Dashboard</h5>
											<p class="m-b-0">Welcome to Mega Able</p>
										</div>
									</div>
									<div class="col-md-4">
										<ul class="breadcrumb-title">
											<li class="breadcrumb-item"><a href="index.html"> <i
													class="fa fa-home"></i>
											</a></li>
											<li class="breadcrumb-item"><a href="#!">Dashboard</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">

										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-block">
														<form class="form-material">
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">ID</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Nome</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Email
																	(exa@gmail.com)</label>
															</div>
															<div class="form-group form-default">
																<input type="password" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Password</label>
															</div>

															<button class="btn btn-primary waves-effect waves-light">Primary
																Button</button>
															<button class="btn btn-success waves-effect waves-light">Success
																Button</button>
															<button class="btn btn-info waves-effect waves-light">Info
																Button</button>
															<button class="btn btn-warning waves-effect waves-light">Warning
																Button</button>
															<button class="btn btn-danger waves-effect waves-light">Danger
																Button</button>
															<button class="btn btn-inverse waves-effect waves-light">Inverse
																Button</button>
															<button
																class="btn btn-disabled disabled waves-effect waves-light">Disabled
																Button</button>
														</form>
													</div>
												</div>
											</div>
											<!-- Page-body end -->
										</div>
										<div id="styleSelector"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Required Jquery -->
			<jsp:include page="javascriptFile.jsp"></jsp:include>
</body>

</html>