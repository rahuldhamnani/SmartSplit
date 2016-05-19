<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Dashboard</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>  
</head>
<body>
${friendsBal}

</body>
<script type="text/template" id="single-profile-template">
        <tr>
            <td>${firstName}</td>
            <td>${lastName}</td>
            <td>${balance}</td>
        </tr>
</script>
<script>
var json= ${friendsBal};    
 
(function () {

    //VIEW
    var UIService = (function () {

        var applyTemplate = function (template, data) {
            return template
            .replace(/\${firstName}/g, data.userBalances.firstName)
            .replace(/\${lastName}/g, data.userBalances.lastName)
            .replace(/\${balance}/g, data.userBalances.balance);
        };
        var renderTopTenResult = function (results) {
            return results.map(function (data) {
                return applyTemplate(resultTemplate, data);
            }).join("");
        };


        var resultTemplate = $("#single-profile-template").html();

        return {
            displayTopTenProfiles: function (results) {
                var rendering = renderTopTenResult(results);
                $("#profile-list").html(rendering);
            }
        }
    }());


    //CONTROLLER
    var App = (function () {
        return {
            loadAndDisplayTopTenResults: function () {
                var promise = json;
                promise.done(function (results) {
                    UIService.displayTopTenProfiles(results);
                });
            }
        };
    }());



    $(document).ready(function () {
    	alert(json.userBalances[0].firstName);
  	  
  	  var a=json.amtOwed;
  	  var c=json.amtOwe;
  	  
  	  var c=json[1];
  	  
  	  
  	  alert(a);
  	  
  	  console.log(JSON.stringify(c)); 
        App.loadAndDisplayTopTenResults();
    });
}());
  
</script>

</html>