<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Kelas_model extends CI_Model
{
    private $_table = "kelas";
    private $_tableDos = "dosen";

    public function getAll()
    {
        return $this->db->from($this->_table)
            ->join('dosen', 'dosen.nip=kelas.nip')
            ->get()
            ->result();
    }

    public function getKls($id)
    {
        return $this->db->get_where($this->_table,$id)->result();
    }

    public function create($data)
    {
        $this->db->insert($this->_table,$data);
    }

    public function update($where,$data)
    {
        $this->db->where($where);
        $this->db->update($this->_table,$data);
    }

    public function delete($where)
    {
        $this->db->where($where);
        $this->db->delete($this->_table);
    }

    public function getDosen()
    {
        return $this->db->get($this->_tableDos)->result();
    }
}