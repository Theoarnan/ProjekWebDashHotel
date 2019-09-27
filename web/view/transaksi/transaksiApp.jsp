<%@page import="com.homestay.model.Pembayaran"%>
<%@page import="com.homestay.model.TransaksiPesan"%>
<%@page import="com.homestay.model.Kamar"%>
<%@page import="com.homestay.model.Tamu"%>
<%@page import="com.homestay.model.Pegawai"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="tamus" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="kamars" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="pegawais" class="java.util.ArrayList" scope="request"/>
<%--<jsp:useBean id="pengaturan" class="java.util.ArrayList" scope="request"/>--%>

<form method="post"  action="Transaksi.do">
<div class="row">
    <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Pilih Tamu
            </div>
            <div class="card-footer row">
                <select name="tamuId" class="form-control col-md-9" id="pilihTamu">
                    <%
                        for (Tamu tamu : (ArrayList<Tamu>) tamus) {
                    %>
                    <option value="<%=tamu.getIdTamu()%>"><%=tamu.getNamaTamu()%></option>
                    <%
                        }
                    %>
                </select>
                &nbsp;&nbsp;&nbsp;
                <button type="button" id="btnPilihTamu" class="btn btn-sm btn-primary">
                    <i class="fas fa-check"></i>
                </button>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Pilih Pegawai
            </div>
            <div class="card-footer row">
                <select name="pegawaiId" class="form-control col-md-9" id="pilihPegawai">
                    <%
                        for (Pegawai pegawai : (ArrayList<Pegawai>) pegawais) {
                    %>
                    <option value="<%=pegawai.getIdPegawai()%>"><%=pegawai.getNamaPegawai()%></option>
                    <%
                        }
                    %>
                </select>
                &nbsp;&nbsp;&nbsp;
                <button type="button" id="btnPilihPegawai" class="btn btn-sm btn-primary">
                    <i class="fas fa-check"></i>
                </button>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Pilih Kamar
            </div>
            <div class="card-footer row">
                <select name="kamarId" class="form-control col-md-9 input-lg" id="pilihKamar">
                    <%
                        for (Kamar kamar : (ArrayList<Kamar>) kamars) {
                    %>
                    <option value="<%=kamar.getIdKamar()%>"><%=kamar.getTypeKamar()%></option>
                    <%
                        }
                    %>
                </select>
                &nbsp;&nbsp;&nbsp;
                <button type="button" id="add-kamar-transaksi" class="btn btn-sm btn-primary">
                    <i class="fas fa-plus"></i>
                </button>
            </div>
        </div>
    </div>
   <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Pilih Tanggal Sewa
            </div>
            <div class="card-footer row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Tgl. CheckIn</label>
                        <input type="date" name="tgl-checkin" class="form-control" required/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label>Tgl. CheckOut</label>
                        <input type="date" name="tgl-checkout" class="form-control" required/>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--    <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Tanggal Check In
            </div>
            <div class="card-footer row">
                <input type="date" class="form-control col-md-9 input-lg" name="tgl_masuk" placeholder="Check In..."  value="" required class="form-control">
                &nbsp;&nbsp;&nbsp;
                <button type="submit" name="submitCheckIn" class="btn btn-sm btn-primary">
                    <i class="fas fa-plus"></i>
                </button>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Tanggal Check Out
            </div>
            <div class="card-footer row">
                <input type="date" class="form-control col-md-9 input-lg" name="tgl_keluar" placeholder="Check Out..."  value="" required class="form-control">
                &nbsp;&nbsp;&nbsp;
                <button type="submit" name="submitCheckOut" class="btn btn-sm btn-primary">
                    <i class="fas fa-plus"></i>
                </button>
            </div>
        </div>
    </div>-->
</div>
<br>
<div class="row">
    <div class="col-lg-12">
        <div class="card">
            <div class="card-footer bg-default text-white">
                Kamar yang akan di Pesan
            </div>
            <div class="card-footer">
                <div class="table-responsive">
                    
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Type Kamar</th>
                                    <th>Harga</th>
                                    <th>Fasilitas</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                        <br/>
                        <input type="hidden" name="tamu-id" id="tamu-id" value=""/>
                        <input type="hidden" name="pegawai-id" id="pegawai-id" value=""/>
                        <input type="hidden" name="lama_sewa" id="lama_sewa" value=""/>
                        <input type="hidden" name="action" value="add"/>
                        <button type="submit" id="proses-transaksi" class="btn btn-primary float-right">
                            <i class="fas fa-save"></i> Simpan
                        </button>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<script>
    $(document).ready(function () {
      var id = "";
      var type = "";
      var harga = "";
      var fasilitas = "";
      var stock = "";
      var sudahPilihTamu = false;
      var sudahPilihPegawai = false;
      function inisialisasiTombohHapus() {
        $(".hapus-item").click(function () {
          $(this).parent().parent().remove();
        });
      }
      $("#add-kamar-transaksi").click(function () {
        var bolehTambah = true;
        $(".cari-id").each(function () {
          var cariId = $(this).val();
          if (parseInt(cariId) === parseInt(id)) {
            bolehTambah = false;
            Swal.fire(
                    'Error',
                    'Kamar Sudah ada di List Pinjaman',
                    'error'
                    );
          }
        });
//        if (stock <= 0) {
//          bolehTambah = false;
//          Swal.fire(
//                  'Error',
//                  'Stock Kamar ' + type + ' Sudah Habis',
//                  'error'
//                  );
//        }
        if (bolehTambah) {
          var barisBaru = "<tr>";
          barisBaru += "<td>" + type + "</td>";
          barisBaru += "<td>" + harga + "</td>";
          barisBaru += "<td>" + fasilitas + "</td>";
          barisBaru += "<td><button class='hapus-item btn btn-danger btn-sm'>Hapus</button></td>";
          barisBaru += "</tr>";
          barisBaru += "<input type='hidden' name='kamar-id' class='cari-id' value='" + id + "'/> ";
          $("table tbody").append(barisBaru);
          inisialisasiTombohHapus();
        }
      });
      $("#pilihTamu").select2();
      $("#pilihPegawai").select2();
      $("#pilihKamar").select2({
        placeholder: 'Pilih Kamar',
        ajax: {
          url: 'Ajax',
          dataType: 'json',
          delay: 100,
          processResults: function (data) {
//                    console.log(data);
            return {
              results: data
            };
          },
          cache: true
        }
      });
      $("#pilihKamar").on("select2:select", function (e) {
        var kamar = e.params.data;
        console.log(kamar);
        id = kamar.id;
        type = kamar.type_kamar;
        harga = kamar.harga;
        fasilitas = kamar.fasilitas;
        stock = kamar.stock;
      });
      $("#btnPilihTamu").click(function () {
        if ($("#pilihTamu").is(":enabled")) {
          $("#pilihTamu").attr("disabled", "disabled");
          sudahPilihTamu = true;
          var idTamu = $("#pilihTamu").val();
          $("#tamu-id").val(idTamu);
        } else {
          $("#pilihTamu").removeAttr("disabled");
          sudahPilihTamu = false;
        }
      });
      $("#btnPilihPegawai").click(function () {
        if ($("#pilihPegawai").is(":enabled")) {
          $("#pilihPegawai").attr("disabled", "disabled");
          sudahPilihPegawai = true;
          var idPegawai = $("#pilihPegawai").val();
          $("#pegawai-id").val(idPegawai);
        } else {
          $("#pilihPegawai").removeAttr("disabled");
          sudahPilihPegawai = false;
        }
      });
      $("#proses-transaksi").click(function (event) {
        var jlhBaris = $('table tbody tr').length;
        if (sudahPilihTamu === false) {
          event.preventDefault();
          Swal.fire(
                  'Error',
                  'Pilih Tamu Terlebih Dahulu',
                  'error'
                  );
        }
        if (sudahPilihPegawai === false) {
          event.preventDefault();
          Swal.fire(
                  'Error',
                  'Pilih Pegawai Terlebih Dahulu',
                  'error'
                  );
      }
        if (jlhBaris <= 0) {
          event.preventDefault();
          Swal.fire(
                  'Error',
                  'Pilih Kamar Terlebih Dahulu',
                  'error'
                  );
        }
      });
    });

</script>