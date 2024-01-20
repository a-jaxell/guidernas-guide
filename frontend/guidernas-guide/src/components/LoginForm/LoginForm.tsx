import React from 'react'

function LoginForm() {
  return (
    <form className='flex flex-col w-4/5'>
        <input className='input input-bordered my-5' type="text" name="username" id="" />
        <input className='input input-bordered my-5' type="text" name="password" id="" />
        <button className='btn btn-primary'>Login</button>
    </form>
  )
}

export default LoginForm