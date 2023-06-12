import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginMangaComponent } from './login-manga.component';

describe('LoginMangaComponent', () => {
  let component: LoginMangaComponent;
  let fixture: ComponentFixture<LoginMangaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginMangaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginMangaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
