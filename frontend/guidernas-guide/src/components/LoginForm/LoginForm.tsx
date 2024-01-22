'use client'
import React, { useState } from 'react'
import { auth } from '@/config/firebase'
import useAuthStore from '@/store/useAuthStore'

function LoginForm() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const { isAuthenticated, login, logout } = useAuthStore();
  const [errorMessage, setErrorMessage] = useState('');


  const handleSubmit = async (e: React.FormEvent<HTMLFormElement> | React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault()
    setErrorMessage('');
    if(!isAuthenticated){
      try {
        await login(email, password);
      } catch (error: any) {
        setErrorMessage(error.message);
      }
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
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            className='input input-bordered my-5'
            type="password"
            name="password"
            placeholder="Password"
            required
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
          { errorMessage && (
            <div role="alert" className="alert alert-error mt-5">
              <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
              <span>{errorMessage}</span>
            </div>
          )}
    </form>
  )
}

export default LoginForm