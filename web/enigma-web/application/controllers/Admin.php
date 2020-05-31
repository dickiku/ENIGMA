<?php 
defined('BASEPATH') OR exit('no direct script access allowed');

class Admin extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("admin_model");
    }

    public function index()
    {
        $data['admin'] = $this->admin_model->getAll();
        $this->load->view("admin/user/listUser",$data);
    }

    public function toAdd()
    {
        $this->load->view("admin/user/add_user");
    }

    public function create()
    {
        $username = $this->input->post('username');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');

        $data = array(
            'username' => $username,
            'email' => $email,
            'password' => $pass
        );

        $this->admin_model->create($data);
        redirect('admin');
    }

    public function toEdit($id)
    {
        $where = array('id_adm' => $id);
        $data['admin'] = $this->admin_model->getAdm($where);
        $this->load->view("admin/user/edit_user",$data);
    }

    public function update()
    {
        $id_adm = $this->input->post('id');
        $username = $this->input->post('username');
        $email = $this->input->post('email');
        $pass = $this->input->post('password');
        
        $data = array(
            'username' => $username,
            'email' => $email,
            'password' => $pass
        );

        $where = array(
            'id_adm' => $id_adm
        );

        $this->admin_model->update($where,$data);
        redirect('admin');
    }

    public function delete($id)
    {
        $where = array('id_adm' => $id);
        $this->admin_model->delete($where);
        redirect('admin');
    }
}