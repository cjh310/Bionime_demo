<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Index</title>
    <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script>
        $(document).ready(function () {
            <c:if test="${not empty message}">
            Swal.fire({
                position: 'top-end',
                <c:if test="${status eq '0'}">
                icon: 'success',
                </c:if>
                <c:if test="${status eq '1'}">
                icon: 'warning',
                </c:if>
                title: "${message}",
                showConfirmButton: false,
                timer: 1500

            })
            </c:if>
        });
    </script>
    <script type="text/javascript">
        function viewSite(sid) {
            $("#getSiteInfo").modal();
            $.ajax({
                type: "GET",
                url: "selectSite",
                data: "sid=" + sid,
                dataType: "json",
                success: function (response) {
                    $("tr").remove(".delClass");
                    $("#site_name").val(response.name);
                    $("#site_id").val(response.sid);
                    response.userInfo.forEach(function (data) {
                        $("#appendTr").after('<tr class="delClass"><td>' + data.staffId + '</td><td>' + data.modifyTime.toLocaleString() + '</td></tr>');

                    })

                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(xhr.status + "\n" + thrownError);
                }
            });
        }

        function delSite(sid) {
            var form = $('<form action="delSite" method="GET">'
                + '<input type="hidden" name="sid" value="'
                + sid + '" />' + '</form>');
            $('body').append(form);
            form.submit();
        }
    </script>
</head>
<body>
<div class="text-center align-self-center">
    <h3>????????????</h3>
    <table border="1" width="30%" style="font-size:20px;" align="center" class="text-center">
        <tr>
            <td><b>??????</b></td>
            <td><b>????????????</b></td>
            <td><b>??????</b></td>
        </tr>
        <c:forEach var="site" items="${allSites}">
            <tr id="site${site.sid}">
                <td>${site.name}</td>
                <td><fmt:formatDate value="${site.modifyTime}" pattern=" yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <button type="button" class="btn btn-lg btn-info" onclick="viewSite(${site.sid})">
                        View
                    </button>
                    <button type="button" class="btn btn-lg btn-danger" onclick="delSite(${site.sid})">Del</button>
                </td>
            </tr>
        </c:forEach>

    </table>
    <form method="get" action="index">
        <button class="btn btn-primary" type="submit">??????</button>
    </form>

    <!-- ?????????????????? -->
    <div id="getSiteInfo" class="modal fade" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h3>????????????</h3>
                    <button type="button" class="close btn-warning"
                            data-dismiss="modal">&times;
                    </button>
                </div>
                <div style="font-size:20px;" class="modal-body col-sm-12 text-center align-self-center">
                    <form method="get" action="updateSite"
                          enctype="multipart/form-data">
                        <input id="site_id" type="hidden" name="sid">
                        ???????????????<input id="site_name" type="text" name="name">
                        <h4>??????????????????</h4>

                        <table border="1" width="90%" style="font-size:20px;" align="center"
                               class="text-center">
                            <tr id="appendTr">
                                <td>????????????</td>
                                <td>????????????</td>
                            </tr>
                        </table>
                        <div style="padding:20px 0px 0px 230px">
                            <input class="btn btn-lg btn-warning" type="submit" value="??????"/>
                        </div>
                    </form>
                </div>
                <div class="modal-footer"></div>
            </div>
        </div>
    </div>
</div>

</body>

</html>