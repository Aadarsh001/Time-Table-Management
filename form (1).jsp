<%-- 
    Document   : index
    Created on : Jun 11, 2015, 11:07:21 AM
    Author     : arushi15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>


    <head>
        <title>ekShiksha Quiz Portal</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <!--<link rel="stylesheet" href="/resources/demos/style.css">-->
        <!--<script src="jquery/jquery.js"></script>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
         <script  type="text/javascript" src="formValidate.js"></script> 
        <script  type="text/javascript" src="javas.js"></script>



        <link rel="stylesheet" href="css/proton/style.min.css">
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>



        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <link rel='stylesheet' href='css/questionDashboard.css'>

    </head>


    <body>
        <%HttpSession sess = request.getSession(false); %>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="jstree.min.js"></script>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src='css/logo.png' alt="error" width='200px' height="50px" /> </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Contents</a></li>
                    <li><a href="#">About us</a></li>
                    <li><a href="#">Contact us</a></li>
                    <li><a href="#">Feedback</a></li>
                    <li><a href="#">Faqs</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Logged in as <%out.println(sess.getAttribute("name"));%><span class="glyphicon glyphicon-cog" aria-hidden="true"></span><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Setting</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->

    </nav><br><br><br>



    <div class="row"><div class='col-md-2'></div><div class='col-md-8'>
            <div style="margin: auto;" >
                <div class="card" >

                    <h1> Quiz Creation Form</h1>
                    <hr style="height : 1px;  background-color: #c8c8c8">
                    <div class="container">      
                        <!--<div class="panel panel-default " style=" width:800px; position: absolute; left:16%;">-->


                        <form class="form-horizontal" action="create" method="post" id="form" >
                            <fieldset>

                                <div class="row">
                                    <div class="col-md-4">
                                        <!-- Text input-->
                                        <div class="control-group">
                                            <label class="control-label" for="Quiz_name">Quiz Name*</label>
                                            <div class="controls">
                                                <input id="Quiz_name" name="Quiz_name" type="text" placeholder="Quiz Name" class=" form-control" style="width: 300px;">
                                            </div>
                                            
                                            <span id="QuizNameError1" class="help-block hidden">
                                                <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Compulsory field.
                                                </div>
                                            </span>
                                            
                                            <span id="QuizNameError2" class="help-block hidden">
                                                <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                 Length should be less than 45 characters.
                                                </div>
                                            </span>
                                            
                                        </div>
                                    </div>




                                    <div class="col-md-4">
                                        <!-- Textarea -->
                                        <div class="control-group">
                                            <label class="control-label" for="Short_quiz_description">Short Quiz Description</label>
                                            <div class="controls">
                                                <textarea class="form-control" id="Short_quiz_description" name="Quiz_description" placeholder="Description"></textarea>
                                            </div>
                                        </div>
                                        
                                        <span id="QuizDescError" class="help-block hidden">
                                                <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Length should be less than 100 characters.
                                                </div>
                                            </span>
                                    </div>
                                </div>

                                <hr style="height : 1px;  background-color: #c8c8c8">

                                <div class="row">
                                    <div class="col-md-2"><div class="panel panel-default panel-body"> <!-- Multiple Radios (inline) -->
                                            <div class="control-group">
                                                <label class="control-label" for="Ownership">Ownership</label>
                                                <div class="controls">

                                                    <label class="radio-custom radio-inline" data-initialize="radio" for="Ownership-0">
                                                        <input  type="radio" id="Public" name="Ownership" value="Public" checked="checked">
                                                        Public
                                                    </label></div>
                                                <div class="controls">
                                                    <label class="radio-custom radio-inline" data-initialize="radio" for="Ownership-1">
                                                        <input  type="radio" id="Private" name="Ownership" value="Private">
                                                        Private
                                                    </label>

                                                </div>
                                            </div></div></div>
                                    <!-- Multiple Radios (inline) -->
                                    <div class="col-md-4">

                                        <div class="control-group">
                                            <div class="panel panel-default" >
                                                <div class="panel-body">
                                                    <label class="control-label" for="Graded">Graded</label>
                                                    <div class="controls" id="rd">

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Graded-0">
                                                            <input  type="radio" id="Graded_yes" name="Graded" value="Yes">
                                                            Yes
                                                        </label>

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Graded-1">
                                                            <input  type="radio" id="Graded_no" name="Graded" value="No" checked="checked" >
                                                            No
                                                        </label>

                                                    </div>

                                                    <div class="control-group" id="panel_graded" style="display:none">
                                                        <label class="control-label" for="Total_marks">Total Marks</label>
                                                        <input name="Total_marks" type="Text" placeholder="M M" style="width:80px" id="TotalMarks">
                                                        <span id="TotalMarksError1" class="help-block hidden">
                                                             <div class="alert alert-danger" role="alert">
                                                             <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                            Marks invalid.
                                                             </div>
                                                        </span>
                                                        
                                                        <span id="TotalMarksError2" class="help-block hidden">
                                                             <div class="alert alert-danger" role="alert">
                                                             <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                             Enter Marks in case of graded quiz.
                                                             </div>
                                                        </span>
                                                    </div>
                                                </div>  </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <!-- Multiple Radios (inline) -->
                                        <div class="control-group">
                                            <div class="panel panel-default ">
                                                <div class="panel-body">
                                                    <label class="control-label" for="Timed">Timed</label>
                                                    <div class="controls">

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Timed-0">
                                                            <input  type="radio" id="Timed_yes" name="Timed" value="Yes">
                                                            Yes
                                                        </label>

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Timed-1">
                                                            <input type="radio" id="Timed_no" name="Timed" value="No" checked="checked">
                                                            No
                                                        </label>

                                                    </div>
                                                </div>


                                                <!-- Spinbox -->
                                                <div id= "panel_timed" style="display:none;">
                                                    <label class="control-label" for="Time_limit" >Time Limit (hr : mm) </label>
                                                    <input id="Hour" type="number" min="0" max="3" step="1" value="0" name="hour">
                                                    <input id="Min" type="number" min="00" max="60" step="1" value="00" name="minute">
                                                </div>
                                                <span id="TimeError" class="help-block hidden">
                                                     <div class="alert alert-danger" role="alert">
                                                      <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                    Time invalid.
                                                     </div>
                                                </span>

                                            </div>
                                        </div>
                                    </div></div>
                                <hr style="height : 1px;  background-color: #c8c8c8">    
                                <!-- Multiple Radios (inline) -->
                                <div class="row">
                                    <div class="col-md-4">

                                        <div class="control-group">
                                            <div class="panel panel-default" >
                                                <div class="panel-body">

                                                    <label class="control-label" for="Randomness">Randomness</label>
                                                    <div class="controls">

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Auto">
                                                            <input type="radio" id="Auto" name="Random" value="Auto" checked="checked">
                                                            Auto
                                                        </label>


                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Manual">
                                                            <input type="radio" id="Manual" name="Random" value="Manual">
                                                            Manual
                                                        </label>

                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-md-4">
                                        <div class="control-group">
                                            <div class="panel panel-default" >
                                                <div class="panel-body">
                                                    <label class="control-label" for="Question_bank">Question Bank</label>
                                                    <div class="controls">

                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="General" >
                                                            <input type="radio" id="General" name="Question_bank" value="General" checked="checked">
                                                            General Pool
                                                        </label>


                                                        <label class="radio-custom radio-inline" data-initialize="radio" for="Private" >
                                                            <input type="radio" id="Private" name="Question_bank" value="Private">
                                                            Private Pool
                                                        </label>
                                                    </div>

                                                </div>
                                            </div>
                                        </div></div>
                                </div>


                                <hr style="height : 1px;  background-color: #c8c8c8">

                                <div class="control-group">
                                    <label class="control-label" for="Option">Options</label>
                                    <div class="controls">
                                        <div class="btn-group selectlist" data-resize="auto" data-initialize="selectlist" id="Long_quiz_description">
                                            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button" id="dropdown-toggle-option" onclick="val()">
                                                <span class="selected-label">Options</span>
                                                <span class="caret"></span>
                                                <span class="sr-only">Toggle Dropdown</span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu">
                                                <li data-value="Option one" id="select"><a href="#">Select</a></li>
                                                <li data-value="Option one" id="weightage"><a href="#">Weightage</a></li>
                                                <li data-value="Option two" id="complexity"><a href="#">Complexity</a></li>

                                            </ul>
                                            <input class="hidden hidden-field" name="Long_quiz_description" readonly="readonly" aria-hidden="true" type="text">
                                        </div>
                                    </div>
                                </div>




                                <div>
                                <div class="panel panel-default" style="display:none;" style=" display:inline-block"  id="panel_weightage">
                                    <div class="panel-body">
                                        <div id="mainBody">
                                            <div id="using_json_2" ></div>

                                            <div id="btn"><input type="button" value="select" onclick="myFunction()"> </div>

                                        </div>
                                        <br>          



                                        <div align="left" id="table" style="display:none" >

                                           <label class="control-label">Enter the corresponding weightages :</label>
                                           <br>
                                            <!--<table width="450px" border="1" >

                                                <tbody>
                                                    <thead>
                                                        <th style="font-family: Times New Roman; font-weight: bold; font-size: 18px">Enter corresponding weightage</th>

                                                    </thead>

                                                </tbody>

                                            </table>-->


                                            <table id="dataTable" width="300px" border="1" class="table table-striped" >

                                                <!--<colgroup>
                                                    <col span="1" style="width: 20%;">
                                                    <col span="1" style="width: 500%;">
                                                    <col span="1" style="width: 30%;">
                                                </colgroup>-->

                                                <tbody id="tbody">
                                                    <tr>

                                                    </tr>

                                                </tbody>

                                            </table>
                                            <br>
                                            <br>
                                          </div>
                                    </div>
                                </div>
                                                                               
                                        <span id="WeightageError1" class="help-block hidden">
                                                 <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Invalid weightage (Total weightage should be 100%).
                                                 </div>
                                        </span>
                                        
                                        <span id="WeightageError2" class="help-block hidden">
                                                 <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Invalid weightage (Select atleast 1 topic and assign weightage).
                                                 </div>
                                        </span>
                                        
                                        <span id="WeightageError3" class="help-block hidden">
                                                 <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Invalid weightage (Each field should contain a value).
                                                 </div>
                                        </span>
                                        
                                        <span id="WeightageError4" class="help-block hidden">
                                                 <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Invalid weightage (Weightage should be a valid number).
                                                 </div>
                                        </span>

                                    
                                </div>
                                <br>






                                <div class="panel panel-default" id="panel_complexity" style="display:none;">

                                    <div class="panel-body">
                                        <label class="control-label">Enter the percentage complexity of overall quiz:</label>
                                        <br>

                                        <div class="control-group" style="display:inline-block">
                                            <label class="control-label" for="Easy%">Easy%</label>
                                            <div class="controls" >
                                                <input id="Easy" name="Easy" type="text" placeholder="%" class=" form-control" style="width: 33%;">
                                            </div>
                                        </div>


                                        <div class="control-group" style="display:inline-block">
                                            <label class="control-label" for="Medium%">Medium%</label>
                                            <div class="controls">
                                                <input id="Medium" name="Medium" type="text" placeholder="%" class=" form-control" style="width: 33%;">
                                            </div>
                                        </div>


                                        <div class="control-group" style="display:inline-block">
                                            <label class="control-label" for="Difficult%">Difficult%</label>
                                            <div class="controls">
                                                <input id="Difficult" name="Difficult" type="text" placeholder="%" class=" form-control" style="width: 33%;">
                                            </div>


                                        </div>
                                        <span id="ComplexityError" class="help-block hidden">
                                             <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                            Invalid weightage (Total weightage should be 100%).
                                             </div>
                                        </span>
                                    </div>
                                </div>

                                <hr style="height : 1px;  background-color: #c8c8c8">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="panel panel-default" id="panel_marks">

                                            <div class="panel-body">
                                                <label class="control-label">Enter the marks for each category of question:</label>
                                                <br>
                                                <div class="control-group">
                                                    <label class="control-label" for="Easy_marks">Easy</label>
                                                    <div class="controls" >
                                                        <input id="Easy_marks" name="Easy_marks" type="text" placeholder="MM" class=" form-control" style="width: 33%;">
                                                    </div>
                                                </div>


                                                <div class="control-group">
                                                    <label class="control-label" for="Medium_marks">Medium</label>
                                                    <div class="controls">
                                                        <input id="Medium_marks" name="Medium_marks" type="text" placeholder="MM" class=" form-control" style="width: 33%;">
                                                    </div>
                                                </div>


                                                <div class="control-group" >
                                                    <label class="control-label" for="Difficult_marks">Difficult</label>
                                                    <div class="controls">
                                                        <input id="Difficult_marks" name="Difficult_marks" type="text" placeholder="MM" class=" form-control" style="width: 33%;">
                                                    </div>
                                                </div>
                                            </div>

                                            <span id="MarksError" class="help-block hidden">
                                                 <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Invalid marks.
                                                 </div>
                                            </span>
                                        </div> </div>

                                    <div class="col-md-4">
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                <!-- Multiple Checkboxes -->
                                                <div class="control-group">
                                                    <label class="control-label" for="Question_type">Select the type of questions:</label>
                                                    <div class="controls">

                                                        <div class="checkbox" id="Multiple_choice_questions">
                                                            <label class="checkbox-custom" data-initialize="checkbox">
                                                                <input name="Multiple_choice_questions" type="checkbox" value="Multiple_choice_questions">
                                                                <span class="checkbox-label">Multiple Choice Questions</span>
                                                            </label>
                                                        </div>

                                                        <div class="checkbox" id="Match_the_columns">
                                                            <label class="checkbox-custom" data-initialize="checkbox">
                                                                <input name="Match_the_columns" type="checkbox" value="Match_the_columns">
                                                                <span class="checkbox-label">Match the columns</span>
                                                            </label>
                                                        </div>

                                                        <div class="checkbox" id="Fill_in_the_blanks">
                                                            <label class="checkbox-custom" data-initialize="checkbox">
                                                                <input name="Fill_in_the_blanks" type="checkbox" value="Fill_in_the_blanks">
                                                                <span class="checkbox-label">Fill in the blanks</span>
                                                            </label>
                                                        </div>

                                                        <div class="checkbox" id="True_false">
                                                            <label class="checkbox-custom" data-initialize="checkbox">
                                                                <input name="True_false" type="checkbox" value="True_false">
                                                                <span class="checkbox-label">True/ False</span>
                                                            </label>
                                                        </div>

                                                        <div class="checkbox" id="All">
                                                            <label class="checkbox-custom" data-initialize="checkbox">
                                                                <input name="All" type="checkbox" value="All">
                                                                <span class="checkbox-label">All</span>
                                                            </label>
                                                        </div></div></div></div>
                                        </div><div class="row"><div class="col-md-10">
                                                <div class="control-group">
                                                    <label class="control-label" for="End_date">End date for test*</label>
                                                    <input type="date" name="datepicker" id="EndDate">
                                                </div>
                                                 <span id="DateError" class="help-block hidden">
                                                <div class="alert alert-danger" role="alert">
                                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                                Compulsory field.
                                                </div>
                                            </span>
                                            </div>
                                        </div>

                                    </div></div>
                                <hr style="height : 1px;  background-color: #c8c8c8"> 
                                <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <input type="submit" value="Submit" onclick="return sub()">

                                    </div></div>
                                <hr style="height : 1px;  background-color: #c8c8c8">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div> </div>
    <script>

        $('#using_json_2').jstree({'core': {
                'data': {
                    'url': 'http://localhost:8084/QuestionBank/GetTopicJson',
                    'data': function (node) {
                        return {'id': node.id};
                    }
                },
                "themes": {
                    'name': 'proton',
                    'responsive': true}
                , "check_callback": true
            },
            "types": {
                "#": {"max_children": 1, "max_depth": -1, "valid_children": ["root"]},
                "root": {"icon": "/static/3.1.1/assets/images/tree_icon.png", "valid_children": ["default"]},
                "default": {"valid_children": ["default", "file"]},
                "file": {"icon": "glyphicon glyphicon-file", "valid_children": []}
            },
            "plugins": ["checkbox"]
        });
        function myFunction() {
            var ref = $('#using_json_2').jstree(true);
            var nodes = ref.get_checked();
            var i;
            var topic_name = new Array();

            for (i = 0; i < nodes.length; i++)
                topic_name[i] = ref.get_text(nodes[i]);



            var arrayLength = nodes.length;



            var table = document.getElementById("dataTable");
            $("#table").show();
            $("#tbody").empty();



            var i;
            for (i = 0; i < arrayLength; i++)
            {
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

               /* var cell1 = row.insertCell(0);
                var element1 = document.createElement("input");
                element1.type = "checkbox";
                element1.name = "chkbox[]";
                cell1.appendChild(element1);*/

                var cell1 = row.insertCell(0);
                cell1.innerHTML = i + 1;


                /*var cell3 = row.insertCell(2);
                var val1 = nodes[i];
                cell3.innerHTML = val1;*/
                
                
                var cell2 = row.insertCell(1);
                var val2 = topic_name[i];
                cell2.innerHTML = val2;




                var cell3 = row.insertCell(2);
                var element3 = document.createElement("input");
                element3.type = "text";
                element3.name = "txtbox[]";
                element3.id = "nodes[" + i + "]";
                cell3.appendChild(element3);

            }
            if(arrayLength == 1)
                document.getElementById("nodes[0]").value=100;
        }
        
    </script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/main.js"></script>


</body>
</html>

