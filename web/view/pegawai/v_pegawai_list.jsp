<%@page import="java.util.ArrayList"%>
<%@page import="com.homestay.model.Pegawai"%>
<jsp:useBean id="pegawais" class="java.util.ArrayList" scope="request" />
<div class="table-responsive">
    <table class="table table-striped" id="tableData">
        <thead>
            <tr >
                <th>No</th>
                <th class="sembunyikan">ID</th>
                <th>Nama Pegawai</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                int no = 1;
                for (Pegawai b : (ArrayList<Pegawai>) pegawais) {

            %>
            <tr>
                <td><%=no++%></td>
                <td class="sembunyikan data-id"><%=b.getIdPegawai()%></td>
                <td class="data-nama"><%=b.getNamaPegawai()%></td>
                <td>
                    <a href="Pegawai.do?action=update&id_pegawai=<%=b.getIdPegawai()%>" class="btn btn-info btn-sm">
                        <i class="fas fa-pencil-alt"></i>
                    </a>
                    <a href="#" class="btn btn-danger btn-sm tombolHapus">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
            </tr>
            
            <% }%>
        </tbody>
    </table>
</div> 
<p></p>
<a href="Pegawai.do?action=add" class="btn btn-primary btn-lg float-right"><i class="fa fa-fw fa-user-plus"></i> Tambah Pegawai</a>

<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" 
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Hapus Pegawai</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <h5>Anda Yakin Hapus data ini?</h5>
                Nama Pegawai : <span id="nama"> </span><br>
            </div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger" id="tombolProsesDelete" href="">Delete</a>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $(".sembunyikan").hide();
        $(".tombolHapus").click(function () {
            var tr = $(this).closest("tr");
            var id = tr.find(".data-id").text();
            var nama = tr.find(".data-nama").text();
            $("#nama").html(nama);
            $("#tombolProsesDelete").attr("href","Pegawai.do?action=delete&id_pegawai="+id);
            $("#modalDelete").modal("show");
        });
    });
</script>