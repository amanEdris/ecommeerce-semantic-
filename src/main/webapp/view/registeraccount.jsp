<%@ page language="java" contentType="text/html; charset==UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <title>Start Page</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
        <meta name="description" content="RealBooks online store">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="./javascript/3ts2ksMwXvKRuG480KNifJ2_JNM.js"></script>
        <script type="text/javascript" src="./javascript/4o300efCt-CXoq1JEC-sVReFz48.js"></script>
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css">
        <link href="./css/superfish.css" rel="stylesheet" type="text/css">
        <link href="./css/responsive.css" rel="stylesheet" type="text/css">
        <link href="./css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="./css/photoswipe.css" rel="stylesheet" type="text/css">
        <link href="./css/cloud-zoom.css" rel="stylesheet" type="text/css">
        <link href="./css/slideshow.css" rel="stylesheet" type="text/css">
        <link href="./css/jquery.prettyPhoto.css" rel="stylesheet" type="text/css">
        <link href="./css/camera.css" rel="stylesheet" type="text/css">
        <link href="./css/photoswipe.css" rel="stylesheet" type="text/css">
        <link href="./css/jquery.bxslider.css" rel="stylesheet" type="text/css">
        <link href="./css/colorbox.css" rel="stylesheet" type="text/css">
        <link href="./css/css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/jquery-ui-1.8.16.custom.css">
        <link rel="stylesheet" type="text/css" href="./css/jquery.fancybox-1.3.4.css" media="screen">


        <script>
            if (navigator.userAgent.match(/Android/i)) {
                var viewport = document.querySelector("meta[name=viewport]");
            }
            if (navigator.userAgent.match(/Android/i)) {
                window.scrollTo(0, 1);
            }
        </script>


        <script type="text/javascript" src="./javascript/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery-ui-1.8.16.custom.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cookie.js"></script>
        <script type="text/javascript" src="./javascript/jquery.fancybox-1.3.4.pack.js"></script>
        <script type="text/javascript" src="./javascript/jquery.colorbox.js"></script>
        <script type="text/javascript" src="./javascript/jquery.jcarousel.min.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cycle.js"></script>
        <script type="text/javascript" src="./javascript/jquery.bxslider.js"></script>
        <script type="text/javascript" src="./javascript/tabs.js"></script>
        <script type="text/javascript" src="./javascript/jQuery.equalHeights.js"></script>
        <script type="text/JavaScript" src="./javascript/jquery.elevatezoom.js"></script>
        <script type="text/javascript" src="./javascript/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="./javascript/jscript_zjquery.anythingslider.js"></script>
        <script type="text/javascript" src="./javascript/common.js"></script>
        <script type="text/javascript" src="./javascript/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="./javascript/jquery.mobile-events.js"></script>
        <script type="text/javascript" src="./javascript/superfish.js"></script>
        <script type="text/javascript" src="./javascript/livesearch.js"></script>
        <script type="text/javascript" src="./javascript/jquery.cookie.js"></script>
        <script type="text/javascript" src="./javascript/superfish.js"></script>
        <script type="text/javascript" src="./javascript/bootstrap.js"></script>
        <script type="text/javascript" src="./javascript/script.js"></script>


    </head>
    <body class="common-home">
        <c:set var="urlRequest" value="http://localhost:8080/UniqueBookApp/book?" scope="page" />
        <div id="body">
            <div class="swipe" style="height: 330px;">
                   <div class="swipe-menu">
                    <ul class="links">
                        <li class="first"><a class="active" href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a class="" href="#"><i class="fa fa-user"></i>My Account</a></li>
                        <li><a class="" href="#"><i class="fa fa-shopping-cart"></i>Shopping Cart</a></li>
                        <li><a class="" href="#"><i class="fa fa-check"></i>Checkout</a></li>
                        <li><a href="#"><i class="fa fa-user"></i>Create an account</a></li><li class="login_h"><a href="#"><i class="fa fa-lock"></i>Login</a></li>   					</ul>

               

                  

                    <ul class="foot">
                        <li><a href="#about">About</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                    </ul>
                    <ul class="foot foot-1">
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                    <ul class="foot foot-2">
                    </ul>
                    <ul class="foot foot-3">
                        <li><a href="#">Order History</a></li>
                    </ul>
                </div>
            </div>
            <div id="page">
                <div id="shadow">
                    <div class="shadow" style="height: 2193px;"></div>
                    <jsp:include page="includesPages/_header.jsp"></jsp:include>
                        <section> 
                            <div id="container">
                                <div  class="container">
                                    <div class="row">

                                        <div class="col-sm-9 col-sm-12    right" id="content">  <div class="breadcrumb">
                                                <a href="/UniqueBookApp">Home</a>
                                            <c:if  test="${empty User}">
                                                » <a href="/UniqueBookApp/account?action=show">Account</a>
                                                » <a href="/UniqueBookApp/account?action=edit" class="last">Register</a>
                                            </c:if>
                                            <c:if  test="${!empty User}">
                                                <a href="/UniqueBookApp/account?action=edit&data=show">>> My Account</a>
                                            </c:if>
                                            </div>
                                            
                                        <c:if  test="${empty User}">
                                            <h1>Register Account</h1>
                                        </c:if>
                                            <div class="box-container">
                                                 <c:if  test="${empty User}">
                                                <p>If you already have an account with us, please login at the <a href="/UniqueBookApp/account?action=login&type=show">login page</a>.</p>
                                                <form class="form-horizontal" action="account" method="post"  id="register">
                                                </c:if>
                                                <c:if  test="${!empty User}">
                                                 <form class="form-horizontal" action="updateAccount" method="post"  id="register">  
                                                </c:if>
                                                     <i>${message}</i>
                                                    <h2>Your Personal Details</h2>
                                                    <div class="content">
                                                        <table class="form">      
                                                            <tbody><tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="firstname"><span class="required">*</span> First Name:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="firstname" value="${User.firstName}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="lastname"><span class="required">*</span> Last Name:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="lastname" value="${User.lastName}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                 <tr>
                                                                    <td>
                                                                        <div class="form-group"><!--if gender male or female select-->
                                                                            <label class="control-label col-sm-5" for="gender"><span class="required">*</span> Gender</label>
                                                                            <div class="controls col-sm-7">
                                                                                 <c:set var="checked" value="checked" scope="page" />
                                                                                <input type="radio" name="male" value="male" <c:if test="${User.gender =='male'}">checked="${checked}"</c:if> />
                                                                                Male     <input type="radio" name="male" value="female" <c:if test="${User.gender =='female'}">checked="${checked}"</c:if> />  Female
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="email"><span class="required">*</span> E-Mail:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="email" value="${User.email}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="telephone"><span class="required">*</span> Telephone:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="telephone" value="${User.phone}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                               
                                                            </tbody></table>
                                                    </div>
                                                    <h2>Your Address</h2>
                                                    <div class="content">
                                                        <table class="form">
                                                            <tbody><tr>
                                                                </tr>
                                                              
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">   <c:set var="location" value="${User.location}"/>
                                                                            <label class="control-label col-sm-5" for="address_1"><span class="required">*</span> Address:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="address_1" value="${location.address}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                               
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="city"><span class="required">*</span> City:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="city" value="${location.city}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="postcode"><span id="postcode-required" class="required" style="display: none;">*</span> Post Code:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="text" name="postcode" value="${location.postalCode}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="country_id"><span class="required">*</span> Country:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <select name="country_id">
                                                                                    <option value=""> --- Please Select --- </option>
                                                                                    <option value="${location.country}" selected="selected">${location.country}</option>
                                                                                    <option value="Aaland Islands">Aaland Islands</option>
                                                                                    <option value="Afghanistan">Afghanistan</option>
                                                                                    <option value="Albania">Albania</option>
                                                                                    <option value="Algeria<">Algeria</option>
                                                                                    <option value="American Samoa">American Samoa</option>
                                                                                    <option value="Andorra">Andorra</option>
                                                                                    <option value="6">Angola</option>
                                                                                    <option value="7">Anguilla</option>
                                                                                    <option value="8">Antarctica</option>
                                                                                    <option value="9">Antigua and Barbuda</option>
                                                                                    <option value="10">Argentina</option>
                                                                                    <option value="11">Armenia</option>
                                                                                    <option value="12">Aruba</option>
                                                                                    <option value="13">Australia</option>
                                                                                    <option value="14">Austria</option>
                                                                                    <option value="15">Azerbaijan</option>
                                                                                    <option value="16">Bahamas</option>
                                                                                    <option value="17">Bahrain</option>
                                                                                    <option value="18">Bangladesh</option>
                                                                                    <option value="19">Barbados</option>
                                                                                    <option value="20">Belarus</option>
                                                                                    <option value="21">Belgium</option>
                                                                                    <option value="22">Belize</option>
                                                                                    <option value="23">Benin</option>
                                                                                    <option value="24">Bermuda</option>
                                                                                    <option value="25">Bhutan</option>
                                                                                    <option value="26">Bolivia</option>
                                                                                    <option value="245">Bonaire, Sint Eustatius and Saba</option>
                                                                                    <option value="27">Bosnia and Herzegovina</option>
                                                                                    <option value="28">Botswana</option>
                                                                                    <option value="29">Bouvet Island</option>
                                                                                    <option value="30">Brazil</option>
                                                                                    <option value="31">British Indian Ocean Territory</option>
                                                                                    <option value="32">Brunei Darussalam</option>
                                                                                    <option value="33">Bulgaria</option>
                                                                                    <option value="34">Burkina Faso</option>
                                                                                    <option value="35">Burundi</option>
                                                                                    <option value="36">Cambodia</option>
                                                                                    <option value="37">Cameroon</option>
                                                                                    <option value="38">Canada</option>
                                                                                    <option value="251">Canary Islands</option>
                                                                                    <option value="39">Cape Verde</option>
                                                                                    <option value="40">Cayman Islands</option>
                                                                                    <option value="41">Central African Republic</option>
                                                                                    <option value="42">Chad</option>
                                                                                    <option value="43">Chile</option>
                                                                                    <option value="44">China</option>
                                                                                    <option value="45">Christmas Island</option>
                                                                                    <option value="46">Cocos (Keeling) Islands</option>
                                                                                    <option value="47">Colombia</option>
                                                                                    <option value="48">Comoros</option>
                                                                                    <option value="49">Congo</option>
                                                                                    <option value="50">Cook Islands</option>
                                                                                    <option value="51">Costa Rica</option>
                                                                                    <option value="52">Cote D'Ivoire</option>
                                                                                    <option value="53">Croatia</option>
                                                                                    <option value="54">Cuba</option>
                                                                                    <option value="246">Curacao</option>
                                                                                    <option value="55">Cyprus</option>
                                                                                    <option value="56">Czech Republic</option>
                                                                                    <option value="237">Democratic Republic of Congo</option>
                                                                                    <option value="57">Denmark</option>
                                                                                    <option value="58">Djibouti</option>
                                                                                    <option value="59">Dominica</option>
                                                                                    <option value="60">Dominican Republic</option>
                                                                                    <option value="61">East Timor</option>
                                                                                    <option value="62">Ecuador</option>
                                                                                    <option value="63">Egypt</option>
                                                                                    <option value="64">El Salvador</option>
                                                                                    <option value="65">Equatorial Guinea</option>
                                                                                    <option value="66">Eritrea</option>
                                                                                    <option value="67">Estonia</option>
                                                                                    <option value="68">Ethiopia</option>
                                                                                    <option value="69">Falkland Islands (Malvinas)</option>
                                                                                    <option value="70">Faroe Islands</option>
                                                                                    <option value="71">Fiji</option>
                                                                                    <option value="72">Finland</option>
                                                                                    <option value="74">France, Metropolitan</option>
                                                                                    <option value="75">French Guiana</option>
                                                                                    <option value="76">French Polynesia</option>
                                                                                    <option value="77">French Southern Territories</option>
                                                                                    <option value="126">FYROM</option>
                                                                                    <option value="78">Gabon</option>
                                                                                    <option value="79">Gambia</option>
                                                                                    <option value="80">Georgia</option>
                                                                                    <option value="81">Germany</option>
                                                                                    <option value="82">Ghana</option>
                                                                                    <option value="83">Gibraltar</option>
                                                                                    <option value="84">Greece</option>
                                                                                    <option value="85">Greenland</option>
                                                                                    <option value="86">Grenada</option>
                                                                                    <option value="87">Guadeloupe</option>
                                                                                    <option value="88">Guam</option>
                                                                                    <option value="89">Guatemala</option>
                                                                                    <option value="241">Guernsey</option>
                                                                                    <option value="90">Guinea</option>
                                                                                    <option value="91">Guinea-Bissau</option>
                                                                                    <option value="92">Guyana</option>
                                                                                    <option value="93">Haiti</option>
                                                                                    <option value="94">Heard and Mc Donald Islands</option>
                                                                                    <option value="95">Honduras</option>
                                                                                    <option value="96">Hong Kong</option>
                                                                                    <option value="97">Hungary</option>
                                                                                    <option value="98">Iceland</option>
                                                                                    <option value="99">India</option>
                                                                                    <option value="100">Indonesia</option>
                                                                                    <option value="101">Iran (Islamic Republic of)</option>
                                                                                    <option value="102">Iraq</option>
                                                                                    <option value="103">Ireland</option>
                                                                                    <option value="104">Israel</option>
                                                                                    <option value="105">Italy</option>
                                                                                    <option value="106">Jamaica</option>
                                                                                    <option value="107">Japan</option>
                                                                                    <option value="240">Jersey</option>
                                                                                    <option value="108">Jordan</option>
                                                                                    <option value="109">Kazakhstan</option>
                                                                                    <option value="110">Kenya</option>
                                                                                    <option value="111">Kiribati</option>
                                                                                    <option value="113">Korea, Republic of</option>
                                                                                    <option value="114">Kuwait</option>
                                                                                    <option value="115">Kyrgyzstan</option>
                                                                                    <option value="116">Lao People's Democratic Republic</option>
                                                                                    <option value="117">Latvia</option>
                                                                                    <option value="118">Lebanon</option>
                                                                                    <option value="119">Lesotho</option>
                                                                                    <option value="120">Liberia</option>
                                                                                    <option value="121">Libyan Arab Jamahiriya</option>
                                                                                    <option value="122">Liechtenstein</option>
                                                                                    <option value="123">Lithuania</option>
                                                                                    <option value="124">Luxembourg</option>
                                                                                    <option value="125">Macau</option>
                                                                                    <option value="127">Madagascar</option>
                                                                                    <option value="128">Malawi</option>
                                                                                    <option value="129">Malaysia</option>
                                                                                    <option value="130">Maldives</option>
                                                                                    <option value="131">Mali</option>
                                                                                    <option value="132">Malta</option>
                                                                                    <option value="133">Marshall Islands</option>
                                                                                    <option value="134">Martinique</option>
                                                                                    <option value="135">Mauritania</option>
                                                                                    <option value="136">Mauritius</option>
                                                                                    <option value="137">Mayotte</option>
                                                                                    <option value="138">Mexico</option>
                                                                                    <option value="139">Micronesia, Federated States of</option>
                                                                                    <option value="140">Moldova, Republic of</option>
                                                                                    <option value="141">Monaco</option>
                                                                                    <option value="142">Mongolia</option>
                                                                                    <option value="242">Montenegro</option>
                                                                                    <option value="143">Montserrat</option>
                                                                                    <option value="144">Morocco</option>
                                                                                    <option value="145">Mozambique</option>
                                                                                    <option value="146">Myanmar</option>
                                                                                    <option value="147">Namibia</option>
                                                                                    <option value="148">Nauru</option>
                                                                                    <option value="149">Nepal</option>
                                                                                    <option value="150">Netherlands</option>
                                                                                    <option value="151">Netherlands Antilles</option>
                                                                                    <option value="152">New Caledonia</option>
                                                                                    <option value="153">New Zealand</option>
                                                                                    <option value="154">Nicaragua</option>
                                                                                    <option value="155">Niger</option>
                                                                                    <option value="156">Nigeria</option>
                                                                                    <option value="157">Niue</option>
                                                                                    <option value="158">Norfolk Island</option>
                                                                                    <option value="112">North Korea</option>
                                                                                    <option value="159">Northern Mariana Islands</option>
                                                                                    <option value="160">Norway</option>
                                                                                    <option value="161">Oman</option>
                                                                                    <option value="162">Pakistan</option>
                                                                                    <option value="163">Palau</option>
                                                                                    <option value="247">Palestinian Territory, Occupied</option>
                                                                                    <option value="164">Panama</option>
                                                                                    <option value="165">Papua New Guinea</option>
                                                                                    <option value="166">Paraguay</option>
                                                                                    <option value="167">Peru</option>
                                                                                    <option value="168">Philippines</option>
                                                                                    <option value="169">Pitcairn</option>
                                                                                    <option value="170">Poland</option>
                                                                                    <option value="171">Portugal</option>
                                                                                    <option value="172">Puerto Rico</option>
                                                                                    <option value="173">Qatar</option>
                                                                                    <option value="174">Reunion</option>
                                                                                    <option value="175">Romania</option>
                                                                                    <option value="176">Russian Federation</option>
                                                                                    <option value="177">Rwanda</option>
                                                                                    <option value="178">Saint Kitts and Nevis</option>
                                                                                    <option value="179">Saint Lucia</option>
                                                                                    <option value="180">Saint Vincent and the Grenadines</option>
                                                                                    <option value="181">Samoa</option>
                                                                                    <option value="182">San Marino</option>
                                                                                    <option value="183">Sao Tome and Principe</option>
                                                                                    <option value="184">Saudi Arabia</option>
                                                                                    <option value="185">Senegal</option>
                                                                                    <option value="243">Serbia</option>
                                                                                    <option value="186">Seychelles</option>
                                                                                    <option value="187">Sierra Leone</option>
                                                                                    <option value="188">Singapore</option>
                                                                                    <option value="189">Slovak Republic</option>
                                                                                    <option value="190">Slovenia</option>
                                                                                    <option value="191">Solomon Islands</option>
                                                                                    <option value="192">Somalia</option>
                                                                                    <option value="193">South Africa</option>
                                                                                    <option value="194">South Georgia &amp; South Sandwich Islands</option>
                                                                                    <option value="248">South Sudan</option>
                                                                                    <option value="195">Spain</option>
                                                                                    <option value="196">Sri Lanka</option>
                                                                                    <option value="249">St. Barthelemy</option>
                                                                                    <option value="197">St. Helena</option>
                                                                                    <option value="250">St. Martin (French part)</option>
                                                                                    <option value="198">St. Pierre and Miquelon</option>
                                                                                    <option value="199">Sudan</option>
                                                                                    <option value="200">Suriname</option>
                                                                                    <option value="201">Svalbard and Jan Mayen Islands</option>
                                                                                    <option value="202">Swaziland</option>
                                                                                    <option value="203">Sweden</option>
                                                                                    <option value="204">Switzerland</option>
                                                                                    <option value="205">Syrian Arab Republic</option>
                                                                                    <option value="206">Taiwan</option>
                                                                                    <option value="207">Tajikistan</option>
                                                                                    <option value="208">Tanzania, United Republic of</option>
                                                                                    <option value="209">Thailand</option>
                                                                                    <option value="210">Togo</option>
                                                                                    <option value="211">Tokelau</option>
                                                                                    <option value="212">Tonga</option>
                                                                                    <option value="213">Trinidad and Tobago</option>
                                                                                    <option value="214">Tunisia</option>
                                                                                    <option value="215">Turkey</option>
                                                                                    <option value="216">Turkmenistan</option>
                                                                                    <option value="217">Turks and Caicos Islands</option>
                                                                                    <option value="218">Tuvalu</option>
                                                                                    <option value="219">Uganda</option>
                                                                                    <option value="220">Ukraine</option>
                                                                                    <option value="221">United Arab Emirates</option>
                                                                                    <option value="222">United Kingdom</option>
                                                                                    <option value="223">United States</option>
                                                                                    <option value="224">United States Minor Outlying Islands</option>
                                                                                    <option value="225">Uruguay</option>
                                                                                    <option value="226">Uzbekistan</option>
                                                                                    <option value="227">Vanuatu</option>
                                                                                    <option value="228">Vatican City State (Holy See)</option>
                                                                                    <option value="229">Venezuela</option>
                                                                                    <option value="230">Viet Nam</option>
                                                                                    <option value="231">Virgin Islands (British)</option>
                                                                                    <option value="232">Virgin Islands (U.S.)</option>
                                                                                    <option value="233">Wallis and Futuna Islands</option>
                                                                                    <option value="234">Western Sahara</option>
                                                                                    <option value="235">Yemen</option>
                                                                                    <option value="238">Zambia</option>
                                                                                    <option value="239">Zimbabwe</option>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                
                                                            </tbody></table>
                                                    </div>
                                                    <h2>Your Password</h2>
                                                    <div class="content">
                                                        <table class="form">
                                                            <tbody><tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="password"><span class="required">*</span> Password:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="password" name="password" value="${User.password}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-group">
                                                                            <label class="control-label col-sm-5" for="confirm"><span class="required">*</span> Password Confirm:</label>
                                                                            <div class="controls col-sm-7">
                                                                                <input class="q1" type="password" name="confirm" value="${User.password}">
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </tbody></table>
                                                    </div>

                                                    <div class="buttons">
                                                        <div class="right">
                                                            <label class="checkbox inline"> 
                                                                <c:if  test="${empty User}">
                                                                    <input type="checkbox" name="agree" value="1">
                                                                    I have read and agree to the <a class="colorbox" href="#" alt="Privacy Policy"><b>Privacy Policy</b></a></label>
                                                                </c:if>                                                                
                                                            <input type="submit" value="Submit" class="buttons"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <aside class="col-sm-2" id="column-right">
                                            <div class="box account">
                                                <div class="box-heading">Account</div>
                                                <div class="box-content">
                                                    <ul class="acount">
                                                        <c:if  test="${empty User}">
                                                            <li><i class="fa fa-lock"></i>&nbsp;&nbsp;<a href="/UniqueBookApp/account?action=login&type=show">Login</a> / <a href="http://localhost:8080/UniqueBookApp/account?action=edit">Register</a></li>                                                           
                                                        </c:if>
                                                        <c:if  test="${!empty User}">
                                                                <li><i class="fa fa-user"></i>&nbsp;&nbsp;<b><a href="/UniqueBookApp/account?action=edit&data=show">My Account</a></b></li>
                                                                <li><i class="fa fa-print"></i>&nbsp;&nbsp;<b><a href="/UniqueBookApp/order?action=show">Order History</a></b></li>
                                                        </c:if>
                                                        
                                                </div>
                                            </div>
                                        </aside>

                                    </div>
                                </div>
                            </div>
                    </div>

                    <div class="clear"></div>
                    </section>
                <jsp:include page="includesPages/_footer.jsp"></jsp:include>

            </div>
        </div>
    </body>
</html>
