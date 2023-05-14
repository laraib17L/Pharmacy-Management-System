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
                 var a= document.Add.name.value;
                 var correct=/^[A-Za-z]+$/;
                
                      if(a=="")
                      {
                              alert("Medicine name is Required !")
                              return false;
                      }
                    var b= document.Add.id.value
                      if(b=="")
                      {
                              alert("Medicine Id is required!")
                              return false;
                      }

                      var c= document.Add.price.value
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
          <h1>Add Medicne</h1>
<form name ="Add" method="post" action="Add" onsubmit="return validate()">

        <label>Medicine name</label>
         <input type="text" name="name" >
        
       
         <label>ID#</label>
         <input type="text" name="id">
          

         <label>Price</label>
         <input type="text" name="price">
        
        
<input type="submit" value="Add">


</form>
</div>

</body>
</html>