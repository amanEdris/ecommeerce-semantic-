<!DOCTYPE html>
<html>
	<head>
		<title>Pagination in Java Web Applications using jTable plugin</title>
		<!-- Include one of jTable styles. -->
		<link href="./css/metro/blue/jtable.css" rel="stylesheet" type="text/css"/>
		<link href="./css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css"/>
		<!-- Include jTable script file. -->
		<!-- Include jTable script file. -->
		<script src="./javascript/jquery-1.7.1.min.js" type="text/javascript"></script>
		<script src="./javascript/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="./javascript/jquery.jtable.js" type="text/javascript"></script>

	</head>
	<body>
		<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
			<h4>Pagination in Java Web Applications jTable</h4>
			<div id="Dashboard"></div>
		</div>

		<script type="text/javascript">
			$(document).ready(function () {
				$('#Dashboard').jtable({
					title: 'Customers', paging: true, //Enable paging
					pageSize: 3, //Set page size (default: 10)
					actions: {
						listAction: 'dashboard?action=listCustomer',
						createAction: 'Controller?action=create',
						updateAction: 'Controller?action=update',
						deleteAction: 'Controller?action=delete'
					},
					fields: {
						firstName: {
							title: 'First Name',
							key: false,
							width: '20%',
							edit: true,
                                                        sort :true
						},
						lastName: {
							title: 'Last Name',
							key: false,
							width: '20%',
							edit: true
						},
						gender: {
							title: 'Gender',
							key: false,
							width: '20%',
							edit: true
						},
						phone: {
							title: 'Phone',
							key: false,
							width: '20%',
							edit: true
						},
						password: {
							title: 'Password',
							key: false,
							width: '20%',
							edit: true
						},
						email: {
							title: 'Email',
							key: true,
							width: '20%',
							edit: true
						},
						city: {
							title: 'City',
							display: function (data) {
								return data.record.location.city;
							}
						},
						country: {
							title: 'Country',
							display: function (data) {
								return data.record.location.city;
							}
						},
						address: {
							title: 'Address',
							display: function (data) {
								return data.record.location.city;
							}
						},
						postalCode: {
								title: 'PostalCode',
								display: function (data) {
									return data.record.location.city;
								}
							}

					}
					//filed ends here
				});
				$('#Dashboard').jtable('load');
			});
		</script>
	</body>
</html>
