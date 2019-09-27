<jsp:useBean id="kamar" class="com.homestay.model.Kamar" scope="request"/>
<form method="post">
    <div class="form-group">
        <label for="">Type Kamar</label>
        <input type="text" name="type_kamar" value="<%=kamar.getTypeKamar() %>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Harga Kamar</label>
        <input type="text" name="harga" value="<%=kamar.getHargaKamar() %>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Fasilitas</label>
        <input type="text" name="fasilitas" value="<%=kamar.getFasilitasKamar()%>" required class="form-control">
    </div>
    <div class="form-group">
        <label for="">Stock</label>
        <input type="number" min="0" value="<%=kamar.getStock()%>" required name="stock" class="form-control">
    </div>
    <div class="form-group">
        <a href="Kamar.do" class="btn btn-info float-left">Kembali</a>
        <input type="submit" class="btn btn-primary float-right" name="submit" value="Simpan"/>
    </div>
</form>