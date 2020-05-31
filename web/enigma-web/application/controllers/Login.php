<?php

defined('BASEPATH') OR exit('no direct script access allowed');

class Login extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("login_model");
    }

    public function index()
    {
        $this->load->view("admin/login/form_login");
    }

    public function proses()
    {
        $username = $this->input->post('username');
        $pass = $this->input->post('pass');

        $where = array(
            'username' => $username,
            // 'password' => md5($pass)
            'password' => $pass
        );

        $cek = $this->login_model->cek_login($where);
        if($cek > 0)
        {
            $data_session = array(
                'nama' => $username,
                'status' => "login"
            );
            $this->session->set_userdata($data_session);
            redirect(site_url("welcome"));
        }
        else
        {
            echo "username dan password salah";
        }
    }

    public function logout()
    {
        $this->session->sess_destroy();
        redirect(site_url("login"));
    }
}