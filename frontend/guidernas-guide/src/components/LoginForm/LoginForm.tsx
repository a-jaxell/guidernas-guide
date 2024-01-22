'use client'
import React, { useState } from 'react'
import { auth } from '@/config/firebase'
import useAuthStore from '@/store/useAuthStore'

function LoginForm() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const { isAuthenticated, login, logout } = useAuthStore();

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement> | React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault()
    if(!isAuthenticated){
      await login(email, password);
    } else {
      logout();
    }
  }

  return (
    <form onSubmit={handleSubmit} className='flex flex-col w-4/5'>
        {isAuthenticated ? <p className='my-5 text text-center text-3xl'>Welcome, {auth.currentUser?.email}</p> : 
        <>
          <input
            className='input input-bordered my-5'
            type="email"
            name="email"
            placeholder='Email'
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            className='input input-bordered my-5'
            type="password"
            name="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </>
        }
          <button
            type='submit'
            className={isAuthenticated ? 'btn btn-error text-xl' : 'btn btn-primary text-xl'}
          >
            {isAuthenticated ? 'Logout' : 'Login'}
          </button>
    </form>
  )
}

export default LoginForm