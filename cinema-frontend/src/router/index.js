import { createRouter, createWebHistory } from 'vue-router'
import ViewMovies from '../views/ViewMovies.vue'
import LogInView from '../views/LogInView.vue'
import ChooseSeatsView from '../views/ChooseSeatsView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
  
    {
      path: '/',
      name: 'allmovies',
      component: ViewMovies
    },
    {
      path: '/login',
      name: 'login',
      component: LogInView
    },
    {
      path: '/seats',
      name: 'seats',
      component: ChooseSeatsView
    }
  ]
})

export default router
