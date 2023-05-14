<html>
  <head>
    <link rel="stylesheet" href="medicine1.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
    <script language="JavaScript" type="text/javaScript">

      function validate()
              {
                 var a= document.Find.name.value;
                 var correct=/^[A-Za-z]+$/;
                
                      if(a=="")
                      {
                              alert("Medicine name is Required !")
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
          <h1>Search Medicine</h1>
<form name ="Find" method="post" action="Find1" onsubmit="return validate()">

        <label>Medicine name</label>
         <input type="text" name="name" >
        
        
<input type="submit" value="Search">


</form>
</div>

</body>
</html>