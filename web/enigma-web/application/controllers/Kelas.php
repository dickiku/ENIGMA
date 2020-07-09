<?php
defined('BASEPATH') OR exit('no direct script access allowed');

class Kelas extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model("kelas_model");
    }
    public function index()
    {
        $data["kelas"] = $this->kelas_model->getAll();
        $this->load->view("admin/kelas/listKelas", $data);
    }
    public function toadd()
    {
        $data["dosen"] = $this->kelas_model->getDosen();
        $this->load->view("admin/kelas/add_kelas",$data);
    }
    public function create()
    {
        $nama = $this->input->post('nama');
        $no = $this->input->post('no');
        $nip = $this->input->post('nip');

        $data = array(
            'nama_kelas' => $nama,
            'no_kelas' => $no,
            'nip' => $nip
        );

        $this->kelas_model->create($data);
        redirect('kelas');
    }
    public function toedit($id)
    {
        $where = array('id_kelas' => $id);
        $data['kelas'] = $this->kelas_model->getKls($where);
        $this->load->view("admin/kelas/edit_kelas", $data);
    }
    public function update()
    {
        $id_kelas = $this->input->post('id');
        $nama = $this->input->post('nama');
        $no = $this->input->post('no');
        $nip = $this->input->post('nip');

        $data = array(
            'nama_kelas' => $nama,
            'no_kelas' => $no,
            'nip' => $nip
        );

        $where = array(
            'id_kelas' => $id_kelas
        );

        $this->kelas_model->update($where,$data);
        redirect('kelas');
    }
    public function delete($id)
    {
        $where = array('id_kelas' => $id);
        $this->kelas_model->delete($where);
        redirect('kelas');
    }
}