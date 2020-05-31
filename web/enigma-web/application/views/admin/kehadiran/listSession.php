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
                        <h1>Session Kehadiran </h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Session Kehadiran</li>
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
                            <!-- <h3 class="card-title">Session Kehadiran</h3> -->
                            <a href="<?= site_url('kehadiran/delSes') ?>" class="btn btn-danger btn-lg" title="delete session kehadiran"><i class="fas fa-trash"></i> Delete Session Kehadiran Hari Ini</a>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Nama Mahasiswa </th>
                                        <th>Id Dosen</th>
                                        <th>Waktu</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <?php foreach ($session as $s): ?>
                                    <tr>
                                        <td><?= $s->nama ?></td>
                                        <td><?= $s->id_dsn ?></td>
                                        <td><?= $s->waktu ?></td>
                                    </tr>
                                    <?php endforeach; ?>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Nama Mahasiswa </th>
                                        <th>Nama Dosen</th>
                                        <th>Waktu</th>
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