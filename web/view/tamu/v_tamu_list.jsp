<%@page import="java.util.ArrayList"%>
<%@page import="com.homestay.model.Tamu"%>
<jsp:useBean id="tamus" class="java.util.ArrayList" scope="request" />
<div class="table-responsive">
    <table class="table table-striped" id="tableData">
        <thead>
            <tr >
                <th>No</th>
                <th class="sembunyikan">ID</th>
                <th>Nama Tamu</th>
                <th>Kartu Identitas</th>
                <th>No Telepon</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                int no = 1;
                for (Tamu b : (ArrayList<Tamu>) tamus) {

            %>
            <tr>
                <td><%=no++%></td>
                <td class="sembunyikan data-id"><%=b.getIdTamu()%></td>
                <td class="data-tamu"><%=b.getNamaTamu()%></td>
                <td class="data-identitas"><%=b.getKartuIdentitas()%></td>
                <td class="data-telpon"><%=b.getNoTelpon()%></td>
                <td>
                    <a href="Tamu.do?action=update&id_tamu=<%=b.getIdTamu()%>" class="btn btn-info btn-sm">
                        <i class="fas fa-pencil-alt"></i>
                    </a>
                    <a href="#" class="btn btn-danger btn-sm tombolHapus">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
            
            <% }%>
        </tbody>
    </table>
</div> 
<p></p>
<a href="Tamu.do?action=add" class="btn btn-primary btn-lg float-right"><i class="fa fa-fw fa-user-plus"></i> Tambah Tamu</a>

<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" 
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Hapus Tamu</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <h5>Anda Yakin Hapus data ini?</h5>
                Nama : <span id="tamu"> </span><br>
                Identitas : <span id="identitas"> </span><br>
                No Telp : <span id="telp"> </span><br>
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
            var tamu = tr.find(".data-tamu").text();
            var identitas = tr.find(".data-identitas").text();
            var telp = tr.find(".data-telpon").text();
            $("#tamu").html(tamu);
            $("#identitas").html(identitas);
            $("#telp").html(telp);
            $("#tombolProsesDelete").attr("href","Tamu.do?action=delete&id_tamu="+id);
            $("#modalDelete").modal("show");
        });
    });
</script>