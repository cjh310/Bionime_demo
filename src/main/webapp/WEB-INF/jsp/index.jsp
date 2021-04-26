<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Index</title>
    <script src="<c:url value='/js/jquery.min.js' />"></script>
    <script src="<c:url value='/js/jquery-3.0.0.min.js' />"></script>
    <script src="<c:url value='/js/bootstrap.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <script type="text/javascript">
        $(document).ready(function() {
        });
    </script>
</head>
<body>

${message}
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addSiteModal">
    addSiteModal
</button>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModal">
    addUserModal
</button>

<!-- 對話盒 -->
<div id="addUserModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                Add User
                <button type="button" class="close btn-warning"
                        data-dismiss="modal">&times;
                </button>
            </div>
            <div class="modal-body">
                <form method="get" action="addUser"
                      enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td><label>員工編號：</label></td>
                            <td><input id="user_staffId" type="text" name="staffId"></td>
                        </tr>
                        <tr>
                            <td><label>護士姓名：</label></td>
                            <td><input id="user_name" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Upload"/></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">${message}</div>
        </div>
    </div>
</div>
<!-- /對話盒 -->
<!-- 對話盒 -->
<div id="addSiteModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                Add Site
                <button type="button" class="close btn-warning"
                        data-dismiss="modal">&times;
                </button>
            </div>
            <div class="modal-body">
                <form method="get" action="addSite"
                      enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td><label>站點名稱：</label></td>
                            <td><input id="side_name" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Upload"/></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">${message}</div>
        </div>
    </div>
</div>
<!-- /對話盒 -->
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Understood</button>
            </div>
        </div>
    </div>
</div>
</body>

</html>