<template>
  <header class="header">
    <ul class="nav">
      <li><router-link to="/">Filmid</router-link></li>
      <li><router-link to="/login">Logi sisse</router-link></li>
    </ul>
    
  </header>
</template>

<script>
export default {
  name: "NavBar",
  
}
</script>

<style>
ul {
  margin: 0;
  padding: 0;
  list-style: none;
}

#pilt {
  display: flex;
  align-items: center;
  
  margin-right: 10px;
  position: absolute;
  right: 0px
}

#dropdown{
  display: none;
  border: solid black 1px;
  margin-top: 0px;
  position: absolute;
  top: 55px;
  right: -10px;

  background-color: #d3d3d3;
  border-radius: 0px 0px 5px 5px;
  padding-right: 50px;
  padding: 10px;
}

#dropdown li{
  padding: 5px;
}

a {
  color: #34495e;
  text-decoration: none;
  font-weight: 500;
}

.header {
  padding-top: .5em;
  padding-bottom: .5em;
  /*border: 1px solid #646174;*/
  background-color: gray;
  /*box-shadow: 0px 0px 14px 0px rgba(0, 0, 0, 0.75);*/
  border-radius: 10px;
  
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap;
  align-items: center;
  
	position: sticky;
	top: 0;
	width: 100%;
  height: 50px;
}

.header img{
  cursor: pointer;
  border-radius: 2px;
}

.nav {
  display: flex;
  margin-left: 15px;
}

.nav a {
  padding: 10px 10px;
  text-align: center;
  display: block;
  color: black;
  font-size: .99em;
}

.nav a:hover{
  background-color: #416486;
}

@media (max-width: 600px){
  #pilt{
    display: none;
  }
  .header {
    flex-direction: column;
    justify-content: center;
  }
}
@media (min-width: 600px) {
  
}
</style>