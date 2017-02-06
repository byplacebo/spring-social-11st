<@layout.extends name="layouts/base.ftl">
	<@layout.put block="contents">
		<div class="ax-panel good">
			<div class="ax-panel-heading">
				Login
			</div>
			<div class="ax-panel-body">
				<form action="/login/authenticate" method="POST">
					<input type="text" name="username" value="" class="ax-inp lg" />
					<div style="height:5px"></div>
					<input type="password" name="password" value="" class="ax-inp lg" />
					<input type="submit" value="Login" class="ax-btn lg good" />
				</form>
			</div>
		</div>

		<br/>

		<h3>Sign in with</h3>

		<ul class="ax-item-group">
			<a class="ax-item" onclick="document.es.submit();"><i class="axi axi-linkedin-square"></i> 11st Connect ID</a>
		</ul>

		<div class="links">
			<a class="ax" href="https://www.axisj.com">https://www.axisj.com</a>, <a class="ax" href="https://github.com/axisj">https://github.com/axisj</a>
		</div>

		<!-- /.container -->
		<form action="/auth/11st" name="es">
			<input type="hidden" name="scope" value="11st:profile:name 11st:profile:id 11st:profile:email 11st:profile:phone 11st:ci:opt"/>
		</form>
	</@layout.put>
</@layout.extends>

