<html>
  <head>
    <link rel="stylesheet" href="medicine.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
    <script language="JavaScript" type="text/javaScript">

      function validate()
              {
                 var a= document.Update.name.value;
                 var correct=/^[A-Za-z]+$/;
                
                      if(a=="")
                      {
                              alert("Medicine name is Required !")
                              return false;
                      }
                      var c= document.Update.price.value
                      if(c=="")
                      {
                              alert("Medicine price is required!")
                              return false;
                      }
                    
                      if(a.match(correct))
                      {
                         return true;  
                      }
                      else
                      {
                          alert("only alphanum allowed in medicine name")
                          return false;
                      }
                     
                      return true;
              }
      
      
      </script>
  </head>
<body>
    <nav>
       <div class="logo">
        <p>Beyond Health Pharmacy</p>
       </div>
    </nav>
        <div class="signup-box">
          <h1>Update Medicine</h1>
<form name ="Update" method="post" action="Update" onsubmit="return validate()">

        <label>Medicine name</label>
         <input type="text" name="name" >

         <label>Price</label>
         <input type="text" name="price">
        
        
<input type="submit" value="Search">


</form>
</div>

</body>
</html>