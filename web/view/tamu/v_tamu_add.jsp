<jsp:useBean id="tamu" class="com.homestay.model.Tamu" scope="request"/>
<form method="post">
    <div class="form-group">
        <label for="">Nama Tamu</label>
        <input type="text" name="nama_tamu" placeholder="Nama..."  value="<%=tamu.getNamaTamu() %>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Kartu Identitas</label>
        <input type="text" name="kartu_identitas" placeholder="Kartu Identitas..."  value="<%=tamu.getKartuIdentitas()%>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">No Telepon</label>
        <input type="number" name="no_telp" placeholder="No Telpon..." value="<%=tamu.getNoTelpon()%>" required class="form-control">
    </div>
    <div class="form-group">
        <a href="Tamu.do" class="btn btn-info float-left">Kembali</a>
        <input type="submit" class="btn btn- btn-primary float-right" name="submit" value="Simpan"/>
    </div>
</form>