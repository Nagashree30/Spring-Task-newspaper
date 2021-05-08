<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>newspaper application</h1>
	<form action="newspaper.do">
		<pre>
<label>Name</label><input type="text" name="name">
<h3>${NameError}</h3>
<label>Cost</label><input type="text" name="cost">
<h3>${CostError}</h3>
<label>NoOfPages</label><input type="text" name="noOfPages">
<h3>${PagesError}</h3>
<label>Language</label><input type="text" name="language">
<h3>${LanguageError}</h3>
<label>Magazine</label><input type="text" name="magazine">
<h3>${MagazineError}</h3>
<input type="submit" value="Register">
</pre>
	</form>
	<div>
		<h2>${msg}</h2>
	</div>
	<pre>
<Form action="search.do">
<label>Enter the Name of the Newspaper</label>
<input type="text" name="name">
<input type="submit" value="Search">
</Form>
	</pre>
	<p>
<label>NewsPaper Image</label>
<input type="file" name="fileImage" id="fileImage" accept="image/png, image/jpeg"/>
</p>
<p>
<img id="thumbnail" alt="Logo preview"/>
</p>
	

</body>
</html>