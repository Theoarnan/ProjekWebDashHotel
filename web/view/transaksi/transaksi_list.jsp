<%@page import="com.homestay.model.Pembayaran"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.homestay.model.TransaksiPesan"%>
<jsp:useBean id="trxList" class="java.util.ArrayList" scope="request"/>
<div class="table-responsive">
    <table class="table table-striped table-bordered"  id="tableData">
        <thead>
            <tr>
                <th>No</th>
                <th class="hidden">ID</th>
                <th>Nama Tamu</th>
                <th>Tanggal Masuk</th>
                <th>Tanggal Tanggal Keluar</th>
                <th>Lama Sewa</th>
                <th>Nama Pegawai</th>
                <th>Total Transaksi</th>
                <th>Action</th>
            </tr>
        <tbody>
            <%
                int no = 1;
                for (TransaksiPesan tp : (ArrayList<TransaksiPesan>) trxList) {

            %>
            <tr>
                <td><%=no++%></td>
                <td class="hidden cari-id"><%=tp.getIdPesan()%></td>
                <td><%=tp.getTamu().getNamaTamu()%> / <%=tp.getTamu().getNoTelpon()%></td>
                <td><%=tp.getTanggalMasuk()%></td>
                <td><%=tp.getTanggalHarusKeluar()%></td>
                <td><%=tp.getLamaSewa() %></td>
                <td><%=tp.getPegawai().getNamaPegawai()%></td>
                <td><%=tp.getTotalTransaksi()%></td>
                <td>
                     <a href="Exel?id=<%=tp.getIdPesan()%>" target="_blank" class="btn btn-sm btn-success">
                        <i class="fas fa-file-excel"></i>
                    </a>
                    <a href="Print?id=<%=tp.getIdPesan()%>" target="_blank" class="btn btn-sm btn-warning">
                        <i class="fas fa-print"></i>
                    </a>
       
                </td>
            </tr>
            <%}%>
        </tbody>
        </thead>
    </table>
</div>
<script>
    $(function () {
      $(".hidden").hide();
      $(".btn-bayar-kamar").click(function () {
        var tr = $(this).closest("tr");
        var id = tr.find(".cari-id").html();
        console.log(id);
        Swal.fire({
          title: 'Anda Yakin Memproses Pembayaran Kamar?',
          text: "Data yang sudah di proses tidak akan dapat dikembalikan",
          type: 'question',
          showCancelButton: true,
          confirmButtonColor: '#d33',
          cancelButtonColor: '#3085d6',
          confirmButtonText: 'Ya, Proses'
        }).then((result) => {
          if (result.value) {
            window.location.href = 'Transaksi.do?action=pembayaran&id_transaksi=' + id;
          }
        });
      });
    });
</script>
