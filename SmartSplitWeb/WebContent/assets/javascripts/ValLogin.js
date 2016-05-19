function valLog()
{
	var userid1 = document.getElementById("email");
	var email = userid1.value;
	var password1 = document.getElementById("password")
	var password = password1.value;
		if(ValidateEmail(email))
		{			
			if(CheckPassword(password))
					return true;
		}
	return false;
}

function ValidateEmail(inputText)
{

	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(inputText == "")
	{
		alert("Please enter you Email address!");
	}
	else if(inputText.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/))
	{
		document.login.email.focus();
		return true;
	}
	else
	{
		alert("You have entered an invalid email address!");
		document.login.email.focus();
		return false;
	}
	return true;
}


function CheckPassword(pswrd)   
{   
	if(pswrd == "")
	{
		alert("Please enter your password!");
		return false;
	}
	return true;
}
