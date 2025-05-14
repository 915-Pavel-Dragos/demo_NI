import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';
import { PLATFORM_ID } from '@angular/core';


export const authGuard: CanActivateFn = () => {
  const platform_id = inject(PLATFORM_ID);
  
  // SSR Check
  if (!isPlatformBrowser(platform_id)) {
    return false;
  }
  
  const token =  localStorage.getItem('token');

  if (token) return true;

  const router = inject(Router);
  router.navigate(['/login']);
  return false;
};
