<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<style>

body {

	margin: 0;
	padding: 0;
	background-image:
		url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLeEJ47c_Y9g5VeNDcUWmFMuvpjB4LsrR3ZQ&s');
	/* Replace with your image file name */
	background-size: 1600px;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
	nav{
		
		text-align: center;
		 padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
	}
	
	 button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
	 table {
            margin: 0 auto;
        }
        button:hover {
            background-color: #6a11cb;
            color: white;
        }

.content {
	text-align: center;
	color: white;
	font-family: Arial, sans-serif;
	padding-top: 20%;
}
</style>
<%-- 
<nav>
<a href="login.html"><h3 class = "border-text"><table><tr><td>Login Hear</td></tr></table></h3> </a>

<a href="regester.html"><h3><table><tr><td>Register Hear</td></tr></table></h3> </a>
--%>

 <div class="container">

        <table>
            <tr>
                <td><button   onclick="alert('Login clicked')"><a href="login.html">Login Here</a></button></td>
                <td><button   onclick="alert('Register clicked')"><a href="regester.html">Register Here</a></button></td>
            </tr>
        </table>
    </div>

</nav>
</head>
<body>
	<div class="content">
		<h1>
			  <h1 style="text-align: center;">Welcome to the Home Page</h1>
		</h1>

	</div>
</body>
</html>
