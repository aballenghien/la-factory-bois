import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PremierePageEtapeComponent } from './premiere-page-etape.component';

describe('PremierePageEtapeComponent', () => {
  let component: PremierePageEtapeComponent;
  let fixture: ComponentFixture<PremierePageEtapeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PremierePageEtapeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PremierePageEtapeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
