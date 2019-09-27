<jsp:useBean id="pegawai" class="com.homestay.model.Pegawai" scope="request"/>
<form method="post">
    <div class="form-group">
        <label for="">Nama Pegawai</label>
        <input type="text" name="nama_pegawai" value="<%=pegawai.getNamaPegawai() %>" required class="form-control">
    </div>
    <div class="form-group">
        <a href="Pegawai.do" class="btn btn-info float-left">Kembali</a>
        <input type="submit" class="btn btn-primary float-right" name="submit" value="Simpan"/>
    </div>
</form>