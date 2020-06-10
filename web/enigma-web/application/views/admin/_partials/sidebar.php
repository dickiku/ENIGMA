<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="<?= site_url('welcome') ?>" class="brand-link">
        <img src="<?= base_url('dist/img/AdminLTELogo.png') ?>" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Dinus Absence</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional)--> 
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="<?= base_url('dist/img/ku.JPG') ?>" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">Bagus Rahma Aulia C</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <li class="nav-item">
                    <a href="<?= site_url('welcome') ?>" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Dashboard
                            <!-- <i class="right fas fa-angle-left"></i> -->
                        </p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="<?= site_url('kehadiran/session') ?>" class="nav-link">
                        <i class="fas fa-list-alt nav-icon"></i>
                        <p>Session</p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="<?= site_url('kehadiran') ?>" class="nav-link">
                        <i class="far fa-list-alt nav-icon"></i>
                        <p>Daftar Kehadiran</p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="<?= site_url('mahasiswa') ?>" class="nav-link">
                        <i class="fas fa-layer-group nav-icon"></i>
                        <p>Daftar Mahasiswa</p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="<?= site_url('dosen') ?>" class="nav-link">
                        <i class="fas fa-layer-group nav-icon"></i>
                        <p>Daftar Dosen</p>
                    </a>
                </li>
                    
                <!-- <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-th"></i>
                        <p>
                            Daftar Kelas
                            <span class="right badge badge-danger">New</span>
                        </p>
                    </a>
                </li> -->

                <li class="nav-item">
                    <a href="<?= site_url('admin') ?>" class="nav-link">
                        <i class="fas fa-user-shield nav-icon"></i>
                        <p>User</p>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="<?= site_url('login/logout') ?>" class="nav-link">
                        <i class="fas fa-sign-out-alt nav-icon"></i>
                        <p>LogOut</p>
                    </a>
                </li>
            
            </ul>
            
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>