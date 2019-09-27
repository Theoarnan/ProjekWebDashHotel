<!DOCTYPE html>
<html>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
        <meta name="author" content="Creative Tim">
        <title>HOME STAY - <tiles:getAsString name="judul" /> </title>
        <!-- Favicon -->
        <link href="assets/img/brand/user.png" rel="icon" type="image/png">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
        <!-- Icons -->
        <link href="assets/vendor/nucleo/css/nucleo.css" rel="stylesheet">
        <link href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <!-- Argon CSS -->
        <link type="text/css" href="assets/css/argon.css?v=1.0.0" rel="stylesheet">
        <script src="assets/vendor/jquery/dist/jquery.min.js"></script>
        <link rel="stylesheet" href="assets/select2/select2.min.css"/>
        <script src="assets/select2/select2.min.js"></script>
    </head>

    <body>
        <!-- Sidenav -->
        <nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-default" id="sidenav-main">
            <div class="container-fluid">
                <!-- Toggler -->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- Brand -->
                <a class="navbar-brand pt-3 bg-secondary"  href="/">
                    <img src="assets/img/brand/logo3.png" class="navbar-brand-img" alt="...">
                    <h2 class=" text-default ">HOME STAY</h2>            
                </a>
                <!-- User -->
                <ul class="nav align-items-center d-md-none">
                    <li class="nav-item dropdown">
                        <a class="nav-link nav-link-icon" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="ni ni-bell-55"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right" aria-labelledby="navbar-default_dropdown_1">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <div class="media align-items-center">
                                <span class="avatar avatar-sm rounded-circle">
                                    <img alt="Image placeholder" src="assets/img/theme/team-1-800x800.jpg">
                                </span>
                            </div>
                        </a>
                        <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
                            <div class=" dropdown-header noti-title">
                                <h6 class="text-overflow m-0">Welcome!</h6>
                            </div>
                            <a href="../examples/profile.html" class="dropdown-item">
                                <i class="ni ni-single-02"></i>
                                <span>My profile</span>
                            </a>
                            <a href="../examples/profile.html" class="dropdown-item">
                                <i class="ni ni-settings-gear-65"></i>
                                <span>Settings</span>
                            </a>
                            <a href="../examples/profile.html" class="dropdown-item">
                                <i class="ni ni-calendar-grid-58"></i>
                                <span>Activity</span>
                            </a>
                            <a href="../examples/profile.html" class="dropdown-item">
                                <i class="ni ni-support-16"></i>
                                <span>Support</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#!" class="dropdown-item">
                                <i class="ni ni-user-run"></i>
                                <span>Logout</span>
                            </a>
                        </div>
                    </li>
                </ul>
                <!-- Collapse -->
                <div class="collapse navbar-collapse" id="sidenav-collapse-main">
                    <!-- Collapse header -->
                    <div class="navbar-collapse-header d-md-none">
                        <div class="row">
                            <div class="col-6 collapse-brand">
                                <a href="../index.html">
                                    <img src="assets/img/brand/blue.png">
                                </a>
                            </div>
                            <div class="col-6 collapse-close">
                                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                                    <span></span>
                                    <span></span>
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- Form -->
                    <form class="mt-1 mb-2 d-md-none">
                        <div class="input-group input-group-rounded input-group-merge">
                            <input type="search" class="form-control form-control-rounded form-control-prepended" placeholder="Search" aria-label="Search">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <span class="fa fa-search"></span>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- Navigation -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link text-white text-body" href="/">
                                <i class=""></i> DASHBOARD
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="Tamu.do">
                                <i class="ni ni-circle-08 text-yellow"></i> Tamu
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="Pegawai.do">
                                <i class="ni ni-badge text-white"></i> Pegawai
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="Kamar.do">
                                <i class="fas fa-bed text-green"></i> Kamar
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="Transaksi.do">
                                <i class="ni ni-app text-grey"></i> Transaksi App
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="Transaksi.do?action=list">
                                <i class="ni ni-bullet-list-67 text-red"></i> List Transaksi Pinjam
                            </a>
                        </li>
                    </ul>
                    <!-- Divider -->

                </div>
            </div>
        </nav>
        <!-- Main content -->
        <div class="main-content">
            <!-- Top navbar -->
            <nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
                <div class="container-fluid">
                    <!-- Brand -->
                    <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="../index.html"></a>
                    <!-- Form -->
                    <form class="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
                        <div class="form-group mb-0">
                            <div class="input-group input-group-alternative">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-search"></i></span>
                                </div>
                                <input class="form-control" placeholder="Search" type="text">
                            </div>
                        </div>
                    </form>
                    <!-- User -->
                    <ul class="navbar-nav align-items-center d-none d-md-flex">
                        <li class="nav-item dropdown">
                            <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <div class="media align-items-center">
                                    <span class="avatar avatar-sm rounded-circle">
                                        <img alt="Image placeholder" src="assets/img/theme/user.png">
                                    </span>
                                    <div class="media-body ml-2 d-none d-lg-block">
                                        <span class="mb-0 text-sm  font-weight-bold">ETP-HOMESTAY</span>
                                    </div>
                                </div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
                                <div class=" dropdown-header noti-title">
                                    <h6 class="text-overflow m-0">Welcome!</h6>
                                </div>
                                <a href="../examples/profile.html" class="dropdown-item">
                                    <i class="ni ni-single-02"></i>
                                    <span>My profile</span>
                                </a>
                                <a href="../examples/profile.html" class="dropdown-item">
                                    <i class="ni ni-settings-gear-65"></i>
                                    <span>Settings</span>
                                </a>
                                <a href="../examples/profile.html" class="dropdown-item">
                                    <i class="ni ni-calendar-grid-58"></i>
                                    <span>Activity</span>
                                </a>
                                <a href="../examples/profile.html" class="dropdown-item">
                                    <i class="ni ni-support-16"></i>
                                    <span>Support</span>
                                </a>
                                <div class="dropdown-divider"></div>
                                <a href="#!" class="dropdown-item">
                                    <i class="ni ni-user-run"></i>
                                    <span>Logout</span>
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <!-- Header -->
            <div class="header bg-gradient-primary pb-7 pt-6 pt-md-7">
                <div class="container-fluid">
                    <div class="header-body">
                        <!-- Card stats -->
                    </div>
                </div>
            </div>
            <!-- Page content -->
            <div class="container-fluid mt--7 bg-gradient-primary">
                <!-- Table -->
                <div class="row">
                    <div class="col">
                        <div class="card shadow">
                            <div class="card-header border-0">
                                <h3 class="mb"><tiles:getAsString name="judul" /></h3>
                            </div>
                            <div class="card-body">
                                <tiles:insert attribute="page"/> 
                            </div>

                        </div>
                    </div>
                </div>
                <!-- Dark table -->

                <!-- Footer -->
                <footer class="footer">
                    <div class="bg-secondary row align-items-center justify-content-md-between">
                        
                    </div>
                </footer>
            </div>
        </div>
        <!-- Argon Scripts -->
        <!-- Core -->

        <script src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Argon JS -->
        <script src="assets/js/argon.js?v=1.0.0"></script>
        <!--Data Tables-->
        <link rel="stylesheet" href="assets/datatables/datatables.min.css"/>
        <script src="assets/datatables/datatables.min.js"></script>
        <script src="assets/vendor/swal/swal.js"></script>

        <script>
            $(function () {
              $('#tableData').DataTable({
                "language": {
                  "paginate": {
                    "previous": "<i class='fa fa-caret-left'></i>",
                    "next": "<i class='fa fa-caret-right'></i>"
                  }
                }
              });
            });
        </script>
    </body>

</html>