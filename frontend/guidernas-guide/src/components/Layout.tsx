export default function Layout({
  children,
  centerContent,
  gap,
}: {
  children: any;
  centerContent?: boolean;
  gap?: number;
}) {
  return (
    <>
      <main
        className={`min-h-screen flex flex-col flex-1 w-full max-w-4xl pb-20 container mx-auto bg-base-100 ${
          gap ? `gap-${gap}` : ""
        } ${centerContent ? "justify-center" : ""}`}
      >
        {children}
      </main>
    </>
  );
}
