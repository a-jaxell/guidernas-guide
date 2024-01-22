'use client'
import React, { useState } from 'react'
import { auth } from '@/config/firebase'
import { signInWithEmailAndPassword } from 'firebase/auth'


function LoginForm() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault()
    const userCredential = await signInWithEmailAndPassword(auth, email, password);
    console.log(userCredential);
  }

  return (
    <form onSubmit={handleSubmit} className='flex flex-col w-4/5'>
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
        <button type='submit' className='btn btn-primary'>Login</button>
    </form>
  )
}

export default LoginForm