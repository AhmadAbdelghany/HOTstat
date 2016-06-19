<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ie.nuim.hotstat.entity.*" %>

<%
Report rep = (Report) request.getAttribute("report");
Double percentage0 = ((ScalarResult)rep.getProfile().getMeasures().get(0).getResult()).getScore() * 100 / 5;
Double percentage1 = ((ScalarResult)rep.getProfile().getMeasures().get(1).getResult()).getScore() * 100 / 5;
Double percentage2 = ((ScalarResult)rep.getProfile().getMeasures().get(2).getResult()).getScore() * 100 / 5;
Double percentage3 = ((ScalarResult)rep.getProfile().getMeasures().get(3).getResult()).getScore() * 100 / 5;
Double percentage4 = ((ScalarResult)rep.getProfile().getMeasures().get(4).getResult()).getScore() * 100 / 5;
Double percentage5 = ((ScalarResult)rep.getProfile().getMeasures().get(5).getResult()).getScore() * 100 / 5;
Double percentage6 = ((ScalarResult)rep.getProfile().getMeasures().get(6).getResult()).getScore() * 100 / 5;
Double percentage7 = ((ScalarResult)rep.getProfile().getMeasures().get(7).getResult()).getScore() * 100 / 5;

int p0 = percentage0.intValue();
int p1 = percentage1.intValue();
int p2 = percentage2.intValue();
int p3 = percentage3.intValue();
int p4 = percentage4.intValue();
int p5 = percentage5.intValue();
int p6 = percentage6.intValue();
int p7 = percentage7.intValue();

%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>HOTstat | Welcome</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
        name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet"
        href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>'>
    <!-- Font Awesome -->
    <link rel="stylesheet"
        href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css'>
    <!-- Ionicons -->
    <link rel="stylesheet"
        href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css'>
    <!-- Theme style -->
    <link rel="stylesheet"
        href='<c:url value="/resources/dist/css/AdminLTE.min.css"/>'>
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
            page. However, you can choose any other skin. Make sure you
            apply the skin class to the body tag so the changes take effect.
      -->
    <link rel="stylesheet"
        href='<c:url value="/resources/dist/css/skins/skin-black.min.css"/>'>
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
    </head>
    <!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-black layout-top-nav">
<div class="wrapper">

  <header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="../../index2.html" class="navbar-brand"><b>HOT</b>stat</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Projects <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Report 1</a></li>
                <li><a href="#">Report 2</a></li>
                <li class="divider"></li>
                <li><a href="#">Other project</a></li>
              </ul>
            </li>
          </ul>
          
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  <!-- Full Width Column -->
  <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1 id="header">
                    Report <small id="reportId">${report.id}</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                    <li class="active">Here</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
                <!-- Your Page Content Here -->

                <!-- Info boxes -->
                <div class="row">
                    <!-- measure 1  (buildings) -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-aqua">
                            <span class="info-box-icon"><i class="fa fa-building-o"></i></span>
                            <div class="info-box-content">
                              <span id="measure1Name" class="info-box-text">${report.profile.measures[0].name}</span>
                              <span id="measure1Result" class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[0].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%=p0 %>%"></div>
                              </div>
                                  <span id="measure1Score" class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[0].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col 1 -->
                    <!-- measure 2 () -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-gray">
                            <span class="info-box-icon"><i class="fa fa-home"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[1].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[1].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p1 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[1].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col 2 -->
                    
                    <!-- fix for small devices only -->
                    <div class="clearfix visible-sm-block"></div>
                    
                    <!-- measure 3 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-green">
                            <span class="info-box-icon"><i class="fa  fa-truck"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[2].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[2].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p2 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[2].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- measure 4 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-navy">
                            <span class="info-box-icon"><i class="fa  fa-map-signs"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[3].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[3].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p3 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[3].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row 1 -->

                
                <div class="row">
                    <!-- measure 5 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-purple">
                            <span class="info-box-icon"><i class="fa  fa-institution"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[4].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[4].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p4 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[4].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col -->
                    
                    <!-- measure 6 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-red">
                            <span class="info-box-icon"><i class="fa  fa-hospital-o"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[7].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[7].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p7 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[7].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col -->

                    <!-- fix for small devices only -->
                    <div class="clearfix visible-sm-block"></div>
                    
                    <!-- measure 7 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-orange">
                            <span class="info-box-icon"><i class="fa  fa-road"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[6].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[6].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p6 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[6].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col -->
                    
                    <!-- measure 8 -->
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box bg-maroon">
                            <span class="info-box-icon"><i class="fa  fa-train"></i></span>
                            <div class="info-box-content">
                              <span class="info-box-text">${report.profile.measures[5].name}</span>
                              <span class="info-box-number">
                                <fmt:formatNumber 
                                     value="${report.profile.measures[5].result.value}" 
                                     maxFractionDigits="1"/>
                              </span>
                              <div class="progress">
                                <div class="progress-bar" style="width: <%= p5 %>%"></div>
                              </div>
                                  <span class="progress-description">
                                  <fmt:formatNumber 
                                     value="${report.profile.measures[5].result.score}" 
                                     maxFractionDigits="1"/>
                                     out of 5
                                  </span>
                            </div>
                            <!-- /.info-box-content -->
                          </div>
                          <!-- /.info-box -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row second row -->


                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-default">
                            <div class="box-header with-border">
                                <h3 class="box-title">Road Types</h3>

                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool"
                                        data-widget="collapse">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-box-tool"
                                        data-widget="remove">
                                        <i class="fa fa-times"></i>
                                    </button>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="chart-responsive">
                                            <canvas id="pieChart1" height="150"></canvas>
                                        </div>
                                        <!-- ./chart-responsive -->
                                    </div>
                                    <!-- /.col -->
                                    <div class="col-md-4">
                                        <ul class="chart-legend clearfix">
                                            <li><i class="fa fa-circle-o text-red"></i> trunk</li>
                                            <li><i class="fa fa-circle-o text-green"></i> tertiary</li>
                                            <li><i class="fa fa-circle-o text-yellow"></i> unclassified</li>
                                            <li><i class="fa fa-circle-o text-aqua"></i> service</li>
                                            <li><i class="fa fa-circle-o text-light-blue"></i> residential</li>
                                            <li><i class="fa fa-circle-o text-light-gray"></i> undefined</li>
                                        </ul>
                                    </div>
                                    <!-- /.col -->
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                    <!-- /.col left -->
                    <div class="col-md-6">
                        <div class="box box-default">
            <div class="box-header with-border">
              <h3 class="box-title">Road Surface</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="row">
                <div class="col-md-8">
                  <div class="chart-responsive">
                    <canvas id="pieChart2" height="150"></canvas>
                  </div>
                  <!-- ./chart-responsive -->
                </div>
                <!-- /.col -->
                <div class="col-md-4">
                  <ul class="chart-legend clearfix">
                    <li><i class="fa fa-circle-o text-red"></i> asphalt</li>
                    <li><i class="fa fa-circle-o text-green"></i> Undefined</li>
                  </ul>
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
                    </div>
                    <!-- /.col right -->
                </div>
                <!-- /.row  second row -->

                <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        
        
  <footer class="main-footer">
    <div class="container">
      Version 0.1.0
    </div>
    <!-- /.container -->
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.2.0 -->
    <script
        src='<c:url value="/resources/plugins/jQuery/jQuery-2.2.0.min.js"/>'></script>
    <!-- Bootstrap 3.3.6 -->
    <script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
    <!-- AdminLTE App -->
    <script src='<c:url value="/resources/dist/js/app.min.js"/>'></script>
    <!-- ChartJS 1.0.1 -->
    <script src="<c:url value="/resources/plugins/chartjs/Chart.min.js"/>"></script>
    <!-- dashboard2 has js for pie chart data -->
    
    <script type="text/javascript">
    $(function () {

          'use strict';

          /* ChartJS
           * -------
           * Here we will create a few charts using ChartJS
           */

          //-------------
          //- PIE CHART -
          //-------------
          // Get context with jQuery - using jQuery's .get() method.
          var pieChartCanvas = $("#pieChart1").get(0).getContext("2d");
          var pieChart = new Chart(pieChartCanvas);
          var PieData = [
            {
              value: 700,
              color: "#f56954",
              highlight: "#f56954",
              label: "trunk"
            },
            {
              value: 500,
              color: "#00a65a",
              highlight: "#00a65a",
              label: "tertiary"
            },
            {
              value: 700,
              color: "#f39c12",
              highlight: "#f39c12",
              label: "unclassified"
            },
            {
              value: 500,
              color: "#00c0ef",
              highlight: "#00c0ef",
              label: "service"
            },
            {
                value: 500,
                color: "#3c8dbc",
                highlight: "#3c8dbc",
                label: "undefined"
              },
              {
                  value: 500,
                  color: "#d2d6de",
                  highlight: "#d2d6de",
                  label: "undefined"
                },
            
          ];
          var pieOptions = {
            //Boolean - Whether we should show a stroke on each segment
            segmentShowStroke: true,
            //String - The colour of each segment stroke
            segmentStrokeColor: "#fff",
            //Number - The width of each segment stroke
            segmentStrokeWidth: 1,
            //Number - The percentage of the chart that we cut out of the middle
            percentageInnerCutout: 50, // This is 0 for Pie charts
            //Number - Amount of animation steps
            animationSteps: 100,
            //String - Animation easing effect
            animationEasing: "easeOutBounce",
            //Boolean - Whether we animate the rotation of the Doughnut
            animateRotate: true,
            //Boolean - Whether we animate scaling the Doughnut from the centre
            animateScale: false,
            //Boolean - whether to make the chart responsive to window resizing
            responsive: true,
            // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
            maintainAspectRatio: false
            
          };
          //Create pie or douhnut chart
          // You can switch between pie and douhnut using the method below.
          pieChart.Doughnut(PieData, pieOptions);
          //-----------------
          //- END PIE CHART -
          //-----------------

          //-------------
          //- PIE CHART -
          //-------------
          // Get context with jQuery - using jQuery's .get() method.
          var pieChartCanvas = $("#pieChart2").get(0).getContext("2d");
          var pieChart = new Chart(pieChartCanvas);
          var PieData = [
            {
              value: 700,
              color: "#f56954",
              highlight: "#f56954",
              label: "undefined"
            },
            {
                value: 700,
                color: "#00a65a",
                highlight: "#00a65a",
                label: "asphalt"
              },
          ];
          var pieOptions = {
            //Boolean - Whether we should show a stroke on each segment
            segmentShowStroke: true,
            //String - The colour of each segment stroke
            segmentStrokeColor: "#fff",
            //Number - The width of each segment stroke
            segmentStrokeWidth: 1,
            //Number - The percentage of the chart that we cut out of the middle
            percentageInnerCutout: 50, // This is 0 for Pie charts
            //Number - Amount of animation steps
            animationSteps: 100,
            //String - Animation easing effect
            animationEasing: "easeOutBounce",
            //Boolean - Whether we animate the rotation of the Doughnut
            animateRotate: true,
            //Boolean - Whether we animate scaling the Doughnut from the centre
            animateScale: false,
            //Boolean - whether to make the chart responsive to window resizing
            responsive: true,
            // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
            maintainAspectRatio: false
          };
          //Create pie or douhnut chart
          // You can switch between pie and douhnut using the method below.
          pieChart.Doughnut(PieData, pieOptions);
          //-----------------
          //- END PIE CHART -
          //-----------------

        });
    </script>

</body>
</html>
