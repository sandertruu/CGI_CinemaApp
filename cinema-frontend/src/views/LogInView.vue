<template>
  <main>
  <Navbar />
  <div class="login">
    <form>
      <h1>Login</h1>
      <label for="email">Email</label>
      <input type="email" required v-model="email">
      <label for="password">Parool</label>
      <input type="password" required v-model="password">
      <div class="container1">
        <button @click="LogIn">Log In</button>
      </div>
    </form>
  </div>
</main>
</template>

<script>
import NavBar from '../components/NavBar.vue'
export default {
  name: 'LogInView',
  components: {
    NavBar
  },
  data: function() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    LogIn() {
      var data = {
        email: this.email,
        password: this.password
      };
      fetch("http://localhost:9090/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
          body: JSON.stringify(data),
      })
      .then(response => {
      // Check if the response is successful (status code 200-299)
      if (response.ok) {
        // Parse the JSON response
        return response.json();
      } else {
        // Handle error responses
        throw new Error("Login failed");
      }
    })
      .then((data) =>  {
      const {id: userId} = data.id;
      localStorage.setItem("userId", userId)
      this.$router.push('/');
      })
      .catch((e) => {
        console.log(e);
        console.log("error");
      });
    },
  }
}
</script>

<style>
.container1 {
  display: flex;
  justify-content: space-evenly;
  align-items: baseline;
}
.login form {
  width: 420px;
  margin: 30px auto;
  background:  rgb(167, 154, 154);
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}
.login label {
  color: rgb(8, 110, 110);
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.8em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bold;
}
.login input{
display: block;
padding: 10px 6px;
width: 100%;
box-sizing: border-box;
border: none;
border-bottom: 1px solid white;
color: blue;
margin-bottom: 30px;
}
.login h2, h1, .submit{
  font-weight: 500;
  text-align: center;
}

#login {
  padding: 10px 15px;
  margin: 40px;
  border: 1px solid black;
  background-color: rgb(99, 97, 97);
  box-shadow: 0px 0px 14px 0px rgba(0, 0, 0, 0.75);

  border-radius: 5px;
  text-align: center;
  width: 75%;
  margin-left: auto;
  margin-right: auto;

}

.login button {
  cursor: pointer;
  margin-top: 20px;
  padding: 8px 10px;
  max-width: 10;
  background-color: #416486;
  color: white;
  text-align: center;
  width: fit-content;
}

@media (max-width: 600px){
  /*
  .login{
    display: flex;
    flex-direction: column;
  }*/
  .login form{
    width: auto;
  }
}
</style>
