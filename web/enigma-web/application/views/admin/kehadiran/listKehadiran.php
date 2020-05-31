<!DOCTYPE html>
<html>
<head>

    <?php $this->load->view("admin/_partials/head_table.php") ?>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Navbar -->
    <?php $this->load->view("admin/_partials/navbar.php") ?>

    <!-- Sidebar -->
    <?php $this->load->view("admin/_partials/sidebar.php") ?>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Daftar Kehadiran Mahasiswa </h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Daftar Kehadiran Mahasiswa</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Daftar Kehadiran Mahasiswa</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nama Mahasiswa </th>
                                        <th>Id Dosen</th>
                                        <th>Waktu</th>
                                        <th>Action</th>
                                        <!--<th>Platform(s)</th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <?php foreach ($kehadiran as $k): ?>
                                    <tr>
                                        <td><?= $k->nama ?></td>
                                        <td><?= $k->id_dsn ?></td>
                                        <td><?= $k->waktu ?></td>
                                        <td>
                                            <a href="" class="btn btn-danger btn-sm" title="delete"><i class="fas fa-trash"></i></a>
                                        </td>
                                        <!--<td>X</td>-->
                                    </tr>
                                    <?php endforeach; ?>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Nama Mahasiswa </th>
                                        <th>Id Dosen</th>
                                        <th>Waktu</th>
                                        <th>Action</th>
                                        <!-- <th>CSS grade</th>-->
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.card-body--> 
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- footer -->
    <?php $this->load->view("admin/_partials/footer.php") ?>


<!-- jQuery -->
<?php $this->load->view("admin/_partials/js_table.php") ?>

</body>
</html>