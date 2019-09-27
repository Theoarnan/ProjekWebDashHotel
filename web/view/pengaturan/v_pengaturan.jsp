<jsp:useBean id="pengaturan" class="com.homestay.model.Pengaturan" scope="request"/>

<form method="post">
    <div class="form-group">
        <label for="">Nama Aplikasi</label>
        <input type="text" name="nama" value="<%=pengaturan.getNama()%>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Jumlah Hari Pinjam</label>
        <input type="number" min="1"  name="jumlah_kamar_pesan" value="<%=pengaturan.getJumlahHariPesan()%>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Denda</label>
        <input type="number" min="500" value="<%=pengaturan.getHarga()%>" required name="denda" class="form-control">
    </div>
    <div class="form-group">
        <label for="">Hitung Jumlah Buku?</label>
        <select name="hitung_lama_sewa" id=""  class="form-control">
            <%
                String selected0 = "selected";
                String selected1 = "";
                if (pengaturan.getHitungJumlahKamar()== 1) {
                    selected1 = "selected";
                    selected0 = "";
                }
            %>
            <option <%=selected1 %>  value="1">Ya</option>
            <option <%=selected0 %> value="0">Tidak</option>
        </select>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-primary float-right" name="submit" value="Simpan"/>
    </div>
</form>