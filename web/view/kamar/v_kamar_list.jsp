<%@page import="java.util.ArrayList"%>
<%@page import="com.homestay.model.Kamar"%>
<jsp:useBean id="kamars" class="java.util.ArrayList" scope="request" />
<div class="table-responsive">
    <table class="table table-striped" id="tableData">
        <thead>
            <tr >
                <th>No</th>
                <th class="sembunyikan">ID</th>
                <th>Type Kamar</th>
                <th>Harga</th>
                <th>Fasilitas</th>
                <th>Stock</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                int no = 1;
                for (Kamar b : (ArrayList<Kamar>) kamars) {

            %>
            <tr>
                <td><%=no++%></td>
                <td class="sembunyikan data-id"><%=b.getIdKamar()%></td>
                <td class="data-type"><%=b.getTypeKamar()%></td>
                <td class="data-harga"><%=b.getHargaKamar()%></td>
                <td class="data-fasilitas"><%=b.getFasilitasKamar()%></td>
                <td class="text-right data-stock"><%=b.getStock()%></td>
                <td>
                    <a href="Kamar.do?action=update&id_kamar=<%=b.getIdKamar()%>" class="btn btn-info btn-sm">
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
<a href="Kamar.do?action=add" class="btn btn-primary btn-lg float-right"><i class="fa fa-fw fa-plus"></i> Tambah Kamar</a>

<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" 
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Hapus Kamar</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <h5>Anda Yakin Hapus data ini?</h5>
                Type Kamar : <span id="type_kamar"> </span><br>
                Harga : <span id="harga"> </span><br>
                Fasilitas : <span id="fasilitas"> </span><br>
                Stock : <span id="stock"> </span><br>
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
            var type = tr.find(".data-type").text();
            var harga = tr.find(".data-harga").text();
            var fasilitas = tr.find(".data-fasilitas").text();
            var stock = tr.find(".data-stock").text();
            $("#type_kamar").html(type);
            $("#harga").html(harga);
            $("#fasilitas").html(fasilitas);
            $("#stock").html(stock);
            $("#tombolProsesDelete").attr("href","Kamar.do?action=delete&id_kamar="+id);
            $("#modalDelete").modal("show");
        });
    });
</script>