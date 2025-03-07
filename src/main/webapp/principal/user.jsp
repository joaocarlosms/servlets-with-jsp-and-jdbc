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
														<form id="formUser" \class="form-material"  action="<%= request.getContextPath( )%>/ServletUserController" method="post">
															<input type="hidden" name="acao" id="acao" value="">															
															<div class="form-group form-default form-static-label">
																<input type="text" name="id" id="id"
																	class="form-control" readonly="readonly" value="${modelLogin.id}"> <span
																	class="form-bar"></span> <label class="float-label">ID</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="nome" id="nome"
																	class="form-control" required="required" value="${modelLogin.nome}"> <span
																	class="form-bar"></span> <label class="float-label">Nome</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="email" id="email"
																	class="form-control" required="required" value="${modelLogin.email}"> <span
																	class="form-bar"></span> <label class="float-label">Email</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="login" id="login"
																	class="form-control" required="required" value="${modelLogin.login}"> <span
																	class="form-bar"></span> <label class="float-label">Login</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="password" name="password" id="password"
																	class="form-control" required="required" value="${modelLogin.password}"> <span
																	class="form-bar"></span> <label class="float-label">Senha</label>
															</div>
															<button type="button" class="btn btn-info waves-effect waves-light" onclick="clearForm();">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															<!-- <button class="btn btn-warning waves-effect waves-light">Warning
																Button</button> -->
															<button type="button" class="btn btn-danger waves-effect waves-light" onclick="deleteUser();">Deletar</button>
														</form>
													</div>
												</div>
											</div>
											<span>${msg}</span>
											
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
			
			
			<script type="text/javascript">
				function clearForm() {
					var elements = document.getElementById("formUser").elements;
					
					for(let p = 0; p < elements.length; p++) {
						elements[p].value = '';
					}
				}
				
				function deleteUser() {
					if(confirm('Deseja realmente excluir os dados')) {
						document.getElementById("formUser").method = 'get';
						document.getElementById("acao").value = 'deletar'
						document.getElementById("formUser").submit();	
					}					
				}
				
				function deleteUserWithAjax() {
					if(confirm('Deseja realmente excluiir os dados?')) {
						var urlAction = document.getElementById('formUser').action;
						var idUser = document.getElementById('id').value;
						
						$.ajax({
							method: "get",
							url: urlAction,
							data: "id"+ idUser + "acao-deletarajax",
							success: function(response) {
								
								clearForm();
								document.getElementById('msg').textContent = response;
							}
						}).fail(function(xhr, status, errorThrow) {
							alert('Erro ao deletar usuário por id:' + xhr.responseText);
						});
					}	
				}
			</script>
</body>

</html>